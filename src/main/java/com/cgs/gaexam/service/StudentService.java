package com.cgs.gaexam.service;

import com.cgs.gaexam.core.Service;
import com.cgs.gaexam.model.Student;
import com.cgs.gaexam.model.dto.StudentInfo;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/05.
 */
public interface StudentService extends Service<Student> {

    List<StudentInfo> findAllStudent();

    int addUserStudent(StudentInfo studentInfo);

    void deleteByUserId(Long userId);

    StudentInfo findByUserId(Long userId);

    void updateUserStudent(StudentInfo studentInfo);

}
