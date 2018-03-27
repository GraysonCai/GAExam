package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.core.ServiceException;
import com.cgs.gaexam.dao.ClassesMapper;
import com.cgs.gaexam.dao.StudentMapper;
import com.cgs.gaexam.dao.UserMapper;
import com.cgs.gaexam.model.Classes;
import com.cgs.gaexam.model.Student;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.model.dto.StudentInfo;
import com.cgs.gaexam.service.StudentService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/05.
 */
@Service
@Transactional
public class StudentServiceImpl extends AbstractService<Student> implements StudentService {
    @Autowired
    private StudentMapper gaStudentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<StudentInfo> findAllStudent() {
        return gaStudentMapper.findAll();
    }

    @Override
    public void deleteByUserId(Long userId) {
        int result = gaStudentMapper.deleteByUserId(userId);
        if (result <= 0)
            throw new ServiceException("删除学生失败！");
        result = userMapper.deleteByIds(String.valueOf(userId));
        if (result <= 0)
            throw new ServiceException("删除用户失败！");
    }

    @Override
    public int addUserStudent(StudentInfo studentInfo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePwd = encoder.encode(studentInfo.getPassword());
        User user = new User(studentInfo.getUsername(), encodePwd, studentInfo.getName(),
                studentInfo.getSex(), studentInfo.getAge(), studentInfo.getPhone(), studentInfo.getEmail(), new Date(), 1L, studentInfo.getEnabled());
        userMapper.insert(user);
        user = userMapper.findByUsername(user.getUsername());
        Student student = new Student(user.getId(), studentInfo.getGrade(), studentInfo.getClassId(), studentInfo.getAcademyId(),
                new Date(), 1L);
        gaStudentMapper.insert(student);

        //更新班级表的学生数量
        long classId = studentInfo.getClassId();
        Classes classes = classesMapper.selectByPrimaryKey(classId);
        student = new Student();
        student.setClassId(classId);
        classes.setStudentNumber(gaStudentMapper.selectCount(student));
        return classesMapper.updateByPrimaryKey(classes);
    }

    @Override
    public StudentInfo findByUserId(Long userId) {
        return gaStudentMapper.findByUserId(userId);
    }

    @Override
    public void updateUserStudent(StudentInfo studentInfo) {
        User user = new User(studentInfo.getUserId(), studentInfo.getName(),
                studentInfo.getSex(), studentInfo.getAge(), studentInfo.getPhone(), studentInfo.getEmail(), studentInfo.getEnabled());
        int result = userMapper.updateUserById(user);
        if (result < 0) {
            throw new ServiceException("更新学生信息失败!");
        }
        Student student = new Student(studentInfo.getStudentId(), studentInfo.getGrade(), studentInfo.getClassId(), studentInfo.getAcademyId());
        result = gaStudentMapper.updateStudentById(student);
        if (result < 0) {
            throw new ServiceException("更新用户信息失败!");
        }
    }

}
