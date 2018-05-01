package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.CourseMapper;
import com.cgs.gaexam.dao.TeacherMapper;
import com.cgs.gaexam.model.Course;
import com.cgs.gaexam.model.Teacher;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.service.CourseService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/16.
 */
@Service
@Transactional
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {
    @Autowired
    private CourseMapper gaCourseMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Course> findTeacherCourseByUser(long userId) {
        Teacher teacher = new Teacher();
        teacher.setUserId(userId);
        teacher = teacherMapper.selectOne(teacher);
        if (teacher == null)
            return null;
        Course course = new Course();
        course.setTeacherId(teacher.getId());
        return gaCourseMapper.select(course);
    }
}
