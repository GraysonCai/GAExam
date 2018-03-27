package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.dao.*;
import com.cgs.gaexam.model.*;
import com.cgs.gaexam.model.dto.ExamInfo;
import com.cgs.gaexam.service.ExamService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import javax.jnlp.IntegrationService;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by CodeGenerator on 2018/03/20.
 */
@Service
@Transactional
public class ExamServiceImpl extends AbstractService<Exam> implements ExamService {
    @Autowired
    private ExamMapper gaExamMapper;

    @Autowired
    private ExamRoomMapper examRoomMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserExamRecordMapper userExamRecordMapper;

    @Override
    public ExamInfo getExamInfoById(long examId) {
        ExamInfo examInfo = gaExamMapper.getExamInfoById(examId);
        String examRoomIds = examInfo.getExamRoomIds();
        String examClassesIds = examInfo.getExamClasses();
        List<ExamRoom> examRoomList = examRoomMapper.selectByIds(examRoomIds);
        List<Classes> classesList = classesMapper.selectByIds(examClassesIds);
        examInfo.setExamRoomNoList(examRoomList.stream()
                .map(examRoom -> examRoom.getRoomNo())
                .collect(Collectors.toList()));
        examInfo.setExamClassList(classesList.stream()
                .map(classes -> classes.getClassName())
                .collect(Collectors.toList()));
        if (ProjectConstant.EXAM_UNPUBLISH_CODE.equals(examInfo.getStatus())) {
            examInfo.setStatusName(ProjectConstant.EXAM_UNPUBLISH);
        } else if (ProjectConstant.EXAM_PUBLISHED_CODE.equals(examInfo.getStatus())) {
            examInfo.setStatusName(ProjectConstant.EXAM_PUBLISHED);
        }
        return examInfo;
    }

    @Override
    public List<ExamInfo> findAllExamInfo() {
        List<ExamInfo> examInfos = gaExamMapper.findAllExamInfo();
        List<ExamRoom> examRooms = examRoomMapper.selectAll();
        Map<Long, String> examRoomMap = new HashMap<>();
        List<String> roomNos;
        //将考场id和考场号联系起来
        for (ExamRoom examRoom : examRooms) {
            examRoomMap.put(examRoom.getId(), examRoom.getRoomNo());
        }
        for (ExamInfo examInfo : examInfos) {
            roomNos = new ArrayList<>();
            if (ProjectConstant.EXAM_UNPUBLISH_CODE.equals(examInfo.getStatus())) {
                examInfo.setStatusName(ProjectConstant.EXAM_UNPUBLISH);
            } else if (ProjectConstant.EXAM_PUBLISHED_CODE.equals(examInfo.getStatus())) {
                examInfo.setStatusName(ProjectConstant.EXAM_PUBLISHED);
            }
            for (String id : examInfo.getExamRoomIds().split(",")) {
                long roomId = Long.parseLong(id);
                if (examRoomMap.containsKey(roomId)) {
                    roomNos.add(examRoomMap.get(roomId));
                }
            }
            examInfo.setExamRoomNoList(roomNos);
            examInfo.setExamRoomNos(roomNos.toString());
        }
        return examInfos;
    }

    @Override
    public void publishById(long examId) {
        Exam exam = new Exam();
        exam.setId(examId);
        exam = gaExamMapper.selectByPrimaryKey(exam);
        this.updateAndPublish(exam);
    }

    @Override
    public void saveAndPublish(Exam exam) {
        //保存、发布考试，并分配座位
        exam.setStatus(ProjectConstant.EXAM_PUBLISHED_CODE);
        gaExamMapper.insert(exam);
        distributeSeating(exam.getPaperId(), exam.getId(), exam.getExamRoomIds(), exam.getExamClasses());
    }

    @Override
    public void updateAndPublish(Exam exam) {
        //修改、发布考试，并分配座位
        exam.setStatus(ProjectConstant.EXAM_PUBLISHED_CODE);
        gaExamMapper.updateByPrimaryKeySelective(exam);
        distributeSeating(exam.getPaperId(), exam.getId(), exam.getExamRoomIds(), exam.getExamClasses());
    }

    //随机分配考场座位
    public void distributeSeating(long paperId, long examId, String examRoomIds, String examClasses) {
        List<ExamRoom> examRoomList = examRoomMapper.selectByIds(examRoomIds);
        List<Classes> classList = classesMapper.selectByIds(examClasses);
        //考场总容量和参与考试总人数
        int totalRoomCapacity = 0, totalStudentNumber = 0;

        for (ExamRoom examRoom : examRoomList) {
            int seating = examRoom.getSeating();
            totalRoomCapacity += seating;
        }
        for (Classes classes : classList) {
            int studentNumber = classes.getStudentNumber();
            totalStudentNumber += studentNumber;
        }

        // 首先用每个班级的人数乘以各个考场的容量占考场总容量之比，算出每个班级在各个考场分配的人数
        int[][] roomAndStudentNumber = new int[examRoomList.size()][classList.size()];
        Random random = new Random();
        //计算j班级在i考场各有多少人
        for (int i = 0; i < roomAndStudentNumber.length; i++) {
            for (int j = 0; j < roomAndStudentNumber[i].length; j++) {
                //根据比例算出j班级在i考场的人数
                roomAndStudentNumber[i][j] = classList.get(j).getStudentNumber() * examRoomList.get(i).getSeating() / totalRoomCapacity;
            }
        }

        //处理未分配考场的人
        for (int i = 0; i < classList.size(); i++) {
            int attendStudent = 0;
            //计算 根据比例算出的i班级在各考场的人数
            for (int j = 0; j < examRoomList.size(); j++) {
                attendStudent += roomAndStudentNumber[j][i];
            }
            //如果i班级计算出来的人数少于该班级的的人数
            if (attendStudent < classList.get(i).getStudentNumber()) {
                //没分配的学生数
                int leftStudentNumber = classList.get(i).getStudentNumber() - attendStudent;
                //则将i班级未分配的人随机选择一个考场分配，每次分配一个，直到未分配人数为0
                while (leftStudentNumber > 0) {
                    roomAndStudentNumber[random.nextInt(examRoomList.size())][i]++;
                    leftStudentNumber--;
                }
            }
        }

        Student student = null;
        List<UserExamRecord> userExamRecords = new ArrayList<>();
        //用于存储j考场i班级当前的座位数（用于累加座位，分隔同班同学）
        int[][] tmp = new int[examRoomList.size()][classList.size()];
        for (int i = 0; i < classList.size(); i++) {
            //查询i班级的学生
            student = new Student();
            student.setClassId(classList.get(i).getId());
            List<Student> studentList = studentMapper.select(student);
            //将已经选择过的学生放到数组的后面，防止选择到重复的，temp用于统计当前已选择的学生数
            int temp = 0;
            for (int j = 0; j < examRoomList.size(); j++) {
                //tmp[j][i]对于j考场的i班级的人，每次增加一个班级数量的步长，可用于隔离同班同学
                for (int k = 0; k < roomAndStudentNumber[j][i]; k++, temp++) {

                    //每次从未被选中的学生中随机抽取一个，座位号为当前j考场i班级的座位tmp[j][i]的学生tempStudent.getUserId()，放到该考场examRoomList.get(j).getRoomNo();
                    int index = random.nextInt(studentList.size() - temp);
                    Student tempStudent = studentList.get(index);
                    //考试安排记录
                    //tmp[j][i] + i + 1，第i个班级的当前累计的座位号，加i是为了与其他班级的座位号区分开，
                    //如两个班级，第1（i=0）个班级是1、3、5、7，那么第2（i=1）个班级就是2，4，6，8
                    UserExamRecord userExamRecord = new UserExamRecord(tempStudent.getUserId(), paperId, examId,
                            examRoomList.get(j).getRoomNo(), tmp[j][i] + i + 1,
                            ProjectConstant.STUDENT_EXAM_WAITING_CODE, ProjectConstant.EXAM_UNATTEND_CODE, new Date(), 1L);
                    userExamRecords.add(userExamRecord);
                    studentList.set(index, studentList.get(studentList.size() - temp - 1));
                    studentList.set(studentList.size() - temp - 1, tempStudent);

                    if (k == roomAndStudentNumber[j][i] - 1) continue;
                    tmp[j][i] += classList.size();
                }
            }
        }

        System.out.println(userExamRecords);
        userExamRecordMapper.insertList(userExamRecords);
    }

    public static void main(String[] args) {
        System.out.println(31 * 40 / 78);
        System.out.println(31 * 38 / 78);
        System.out.println(32 * 40 / 78);
        System.out.println(32 * 38 / 78);
    }

}
