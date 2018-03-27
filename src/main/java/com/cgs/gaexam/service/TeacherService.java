package com.cgs.gaexam.service;

import com.cgs.gaexam.model.Teacher;
import com.cgs.gaexam.core.Service;
import com.cgs.gaexam.model.dto.TeacherInfo;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/05.
 */
public interface TeacherService extends Service<Teacher> {

    List<TeacherInfo> findAllTeacher();

    int addUserTeacher(TeacherInfo teacherInfo);

    void deleteByUserId(Long userId);

    TeacherInfo findByUserId(Long userId);

    void updateUserTeacher(TeacherInfo teacherInfo);
}
