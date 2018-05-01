package com.cgs.gaexam.service;

import com.cgs.gaexam.model.Course;
import com.cgs.gaexam.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/16.
 */
public interface CourseService extends Service<Course> {

    /**
     * 通过教师查找课程
     *
     * @param teacherId
     * @return
     */
    List<Course> findTeacherCourseByUser(long teacherId);
}
