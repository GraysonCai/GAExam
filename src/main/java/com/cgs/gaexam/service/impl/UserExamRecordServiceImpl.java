package com.cgs.gaexam.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.dao.*;
import com.cgs.gaexam.model.*;
import com.cgs.gaexam.model.dto.*;
import com.cgs.gaexam.service.UserExamRecordService;
import com.cgs.gaexam.core.AbstractService;
import com.cgs.gaexam.service.UserQuestionRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by CodeGenerator on 2018/03/21.
 */
@Service
@Transactional
public class UserExamRecordServiceImpl extends AbstractService<UserExamRecord> implements UserExamRecordService {
    @Autowired
    private UserExamRecordMapper gaUserExamRecordMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private UserQuestionRecordMapper userQuestionRecordMapper;

    @Override
    public List<UserExamRecordInfo> findUserExamRecordInfo(long userId) {
        return gaUserExamRecordMapper.findUserExamRecordInfo(userId);
    }

    @Override
    public List<UserExamRecordInfo> findUserHistoryExamRecordInfo(long userId) {
        List<UserExamRecordInfo> examRecords = gaUserExamRecordMapper.findUserHistoryExamRecordInfo(userId);
        return setExamResultAndStatusName(examRecords);
    }

    @Override
    public UserExamRecordInfo getUserHistoryExamRecordDetailInfo(long recordId) {
        UserExamRecordInfo examRecords = gaUserExamRecordMapper.getUserHistoryExamRecordDetailInfo(recordId);
        return setExamResultAndStatusName(Arrays.asList(examRecords)).get(0);
    }

    @Override
    public List<UserExamRecordInfo> findAllExamRecordInfo(long examId) {
        List<UserExamRecordInfo> examRecords = gaUserExamRecordMapper.findAllExamRecordInfo(examId);
        return setExamResultAndStatusName(examRecords);
    }

    @Override
    public List<UserExamRecordInfo> findWaitToReadPaperByUser(long userId) {
        List<UserExamRecordInfo> papers = gaUserExamRecordMapper.findWaitToReadPaperByUser(userId);
        return papers;
    }

    private List<UserExamRecordInfo> setExamResultAndStatusName(List<UserExamRecordInfo> examRecords) {
        for (UserExamRecordInfo examRecord : examRecords) {
            if (examRecord.getStatus() != null) {
                String status = ProjectConstant.getStudentExamStatus(examRecord.getStatus());
                examRecord.setStatusName(status);
            }
            if (examRecord.getResult() != null) {
                String result = ProjectConstant.getStudentExamResult(examRecord.getResult());
                examRecord.setResultName(result);

            }
        }
        return examRecords;
    }

    @Override
    public void submitAnswerSheet(UserExamRecord userExamRecord) {
        //TODO
        String answerSheet = userExamRecord.getAnswerSheet();
        long paperId = userExamRecord.getPaperId();
        Paper paper = paperMapper.selectByPrimaryKey(paperId);
        long examId = userExamRecord.getExamId();
        long userId = userExamRecord.getUserId();
//        Exam exam = examMapper.selectByPrimaryKey(examId);
        //查找考试记录
        UserExamRecord examRecord = new UserExamRecord();
        examRecord.setUserId(userExamRecord.getUserId());
        examRecord.setExamId(examId);
        examRecord.setPaperId(paperId);
        examRecord = gaUserExamRecordMapper.selectOne(examRecord);
        examRecord.setObjectiveScore(calculateObjectiveScore(userId, examId, paper, answerSheet));

        examRecord.setAnswerSheet(answerSheet);
        examRecord.setFinishedDate(new Date());
        if (paper.getSubjective() == ProjectConstant.OBJECTIVE) {
            examRecord.setStatus(ProjectConstant.STUDENT_EXAM_FINISHED_CODE);
            if (examRecord.getObjectiveScore() >= paper.getPassScore()) {
                examRecord.setResult(ProjectConstant.EXAM_PASS_CODE);
            } else {
                examRecord.setResult(ProjectConstant.EXAM_FAILED_CODE);
            }
        } else if (paper.getSubjective() == ProjectConstant.SUBJECTIVE) {
            examRecord.setStatus(ProjectConstant.STUDENT_EXAM_READING_PAPER_CODE);
            examRecord.setResult(ProjectConstant.EXAM_RESULT_WAITING_CODE);
        }
        gaUserExamRecordMapper.updateByPrimaryKeySelective(examRecord);
        System.out.println(examRecord);
    }

    private float calculateObjectiveScore(long userId, long examId, Paper paper, String answerSheet) {
        List<AnswerSheetItem> answerSheetItems = JSON.parseArray(answerSheet, AnswerSheetItem.class);
        boolean isSubjective = false;
        float objectiveScore = 0F;
        //获取正确答案列表
        String[] questionIds = paper.getQuestionIds().trim().split(",");
        List<Question> questions = paperMapper.findQuestionAnswer(questionIds);
        List<UserQuestionRecord> userQuestionRecords = new ArrayList<>();
        Map<Long, String> answerMap = new HashMap<>();
        questions.forEach(question -> answerMap.put(question.getId(), question.getAnswer()));
        for (AnswerSheetItem answerSheetItem : answerSheetItems) {
            //记录作答情况
            UserQuestionRecord userQuestionRecord = new UserQuestionRecord(userId, examId, answerSheetItem.getQuestionId(),
                    answerSheetItem.getScore(), 0F, new Date(), 1L);
            //计算答题得分
            String questionAnswer = answerMap.get(answerSheetItem.getQuestionId());
            float score = answerSheetItem.getScore();
            if (answerSheetItem.getQuestionType() == 1
                    || answerSheetItem.getQuestionType() == 3) {//单选题、判断题
                userQuestionRecord.setSubjective(ProjectConstant.OBJECTIVE);    //主观题
                //单选题答对
                if (answerSheetItem.getAnswer().equals(questionAnswer)) {
                    objectiveScore += score;
                    userQuestionRecord.setIsRight(ProjectConstant.RIGHT);
                    userQuestionRecord.setGainScore(score);
                } else {
                    userQuestionRecord.setIsRight(ProjectConstant.WRONG);
                }
            } else if (answerSheetItem.getQuestionType() == 2) {//多选题
                userQuestionRecord.setSubjective(ProjectConstant.OBJECTIVE);    //客观题
                Set<String> sheetAnswerSet = new HashSet<>(Arrays.asList(questionAnswer.trim().split(",")));
                Set<String> questionAnswerSet = new HashSet<>(Arrays.asList(answerSheetItem.getAnswer().trim().split(",")));
                //多选题答对
                if (!sheetAnswerSet.addAll(questionAnswerSet)) {
                    objectiveScore += score;
                    userQuestionRecord.setIsRight(ProjectConstant.RIGHT);
                    userQuestionRecord.setGainScore(score);
                } else {
                    userQuestionRecord.setIsRight(ProjectConstant.WRONG);
                }
            } else {
                userQuestionRecord.setSubjective(ProjectConstant.SUBJECTIVE);
            }
            userQuestionRecords.add(userQuestionRecord);
        }
        userQuestionRecordMapper.insertList(userQuestionRecords);
        System.out.println(objectiveScore);
        return objectiveScore;
    }

    @Override
    public PieChartOption getPieChartOption(long userId, long examId) {
        List<UserExamRecordInfo> userExamRecordInfoList = gaUserExamRecordMapper.findUserClassExamSituation(userId, examId);
        float totalScore = userExamRecordInfoList.get(0).getTotalScore();
        float passScore = userExamRecordInfoList.get(0).getPassScore();
        float paperScore = userExamRecordInfoList.get(0).getPaperScore();
        String className = userExamRecordInfoList.get(0).getClassName();
        String examName = userExamRecordInfoList.get(0).getExamName();

        float each = paperScore / 10;
        float[] temp = new float[6];
        List<Data<Integer>> dataList = new ArrayList<>();
        Data<Integer> data;
        for (int i = 0; i < 6; i++) {
            temp[i] = i == 5 ? 0 : paperScore - each * i;
            if (i == 0) {
                data = new Data("[" + (paperScore - each) + "," + paperScore + "]", 0);
            } else if (i == 4) {
                data = new Data("[" + 0 + "," + (paperScore - each * (i)) + ")", 0);
            } else if (i == 5) {
                data = new Data(ProjectConstant.EXAM_UNATTEND, 0);
            } else {
                data = new Data("[" + (paperScore - each * (i + 1)) + "," + (paperScore - each * (i)) + ")", 0);
            }
            dataList.add(data);
        }
        userExamRecordInfoList.forEach(userExamRecordInfo -> {
            float gainScore = userExamRecordInfo.getTotalScore();
            //完成考试
            if (ProjectConstant.STUDENT_EXAM_FINISHED_CODE.equals(userExamRecordInfo.getStatus())) {
                if ((temp[0] > gainScore
                        && temp[1] < gainScore)
                        || !(Math.abs(temp[0] - gainScore) > 0
                        || !(Math.abs(temp[1] - gainScore) > 0))) {
                    dataList.get(0).setValue(dataList.get(0).getValue() + 1);
                } else if ((temp[1] > gainScore
                        && temp[2] < gainScore)
                        || !(Math.abs(temp[2] - gainScore) > 0)) {
                    dataList.get(1).setValue(dataList.get(1).getValue() + 1);
                } else if ((temp[2] > gainScore
                        && temp[3] < gainScore)
                        || !(Math.abs(temp[3] - gainScore) > 0)) {
                    dataList.get(2).setValue(dataList.get(2).getValue() + 1);
                } else if ((temp[3] > gainScore
                        && temp[4] < gainScore)
                        || !(Math.abs(temp[4] - gainScore) > 0)) {
                    dataList.get(3).setValue(dataList.get(3).getValue() + 1);
                } else if ((temp[4] > gainScore
                        && temp[5] < gainScore)
                        || !(Math.abs(temp[5] - gainScore) > 0)) {
                    dataList.get(4).setValue(dataList.get(4).getValue() + 1);
                }
            } else {
                dataList.get(5).setValue(dataList.get(5).getValue() + 1);
            }
        });
        PieChartOption pieChartOption = new PieChartOption();
        pieChartOption.setClassName(className);
        pieChartOption.setExamName(examName);
        pieChartOption.setData(dataList);
        return pieChartOption;
    }

    @Override
    public BarChartOption getBarChartOption(long userId) {
        List<Data<Float>> dataList = gaUserExamRecordMapper.findExamNameAndScore(userId);
        String[] xAxisData = new String[dataList.size()];
        float[] seriesData = new float[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            xAxisData[i] = dataList.get(i).getName();
            seriesData[i] = dataList.get(i).getValue();
        }
        BarChartOption barChartOption = new BarChartOption(xAxisData, seriesData);
        return barChartOption;
    }

    @Override
    public LineChartOption getLineChartOption(long userId) {
        List<Data<Integer>> dataList = gaUserExamRecordMapper.findExamRank(userId, new Date());
        String[] xAxisData = new String[dataList.size()];
        float[] seriesData = new float[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            xAxisData[i] = dataList.get(i).getName();
            seriesData[i] = dataList.get(i).getValue();
        }
        Classes classes = classesMapper.getUserClass(userId);
        LineChartOption lineChartOption = new LineChartOption(xAxisData, seriesData, classes.getStudentNumber());
        return lineChartOption;
    }

    @Override
    public void submitMarkScore(ReadExamInfo readExamInfo) {
        List<QuestionScore> markList = readExamInfo.getMarkList();
        long examRecordId = readExamInfo.getExamRecordId();
        float totalSubjectiveScore = 0;
        long examId = readExamInfo.getExamId();
        long userId = readExamInfo.getUserId();
        float passScore = readExamInfo.getPassScore();
        List<Long> questionIds = new ArrayList<>();
        Map<Long, Float> questionScoreMap = new HashMap<>();
        for (QuestionScore questionScore : markList) {
            totalSubjectiveScore += questionScore.getScore();
            questionIds.add(questionScore.getQuestionId());
            questionScoreMap.put(questionScore.getQuestionId(), questionScore.getScore());
        }
        List<UserQuestionRecord> questionRecordList = userQuestionRecordMapper.findBy(examId, userId, questionIds);
        for (UserQuestionRecord questionRecord : questionRecordList) {
            long questionId = questionRecord.getQuestionId();
            if (questionScoreMap.containsKey(questionId)) {
                questionRecord.setGainScore(questionScoreMap.get(questionId));
            }
        }
        UserExamRecord userExamRecord = new UserExamRecord();
        userExamRecord.setId(examRecordId);
        userExamRecord = gaUserExamRecordMapper.selectOne(userExamRecord);
        userExamRecord.setSubjectiveScore(totalSubjectiveScore);
        userExamRecord.setStatus(ProjectConstant.STUDENT_EXAM_FINISHED_CODE);
        float totalScore = userExamRecord.getObjectiveScore() + userExamRecord.getSubjectiveScore();
        //如果分数大于等于及格分数，则考试结果为及格，否则为不及格
        if (totalScore > passScore || !(Math.abs(passScore - totalScore) > 0)) {
            userExamRecord.setResult(ProjectConstant.EXAM_PASS_CODE);
        } else {
            userExamRecord.setResult(ProjectConstant.EXAM_FAILED_CODE);
        }
        for (UserQuestionRecord userQuestionRecord : questionRecordList) {
            userQuestionRecordMapper.updateByPrimaryKey(userQuestionRecord);
        }
        gaUserExamRecordMapper.updateByPrimaryKey(userExamRecord);
        System.out.println(userExamRecord);
        System.out.println(totalSubjectiveScore);
        System.out.println(questionRecordList);
    }

    public static void main(String[] args) {
        float f1 = 15F;
        int i1 = 10;
        float divide = f1 / i1;
        System.out.println(divide);
    }
}
