package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.CourseMapper;
import com.cgs.gaexam.model.Course;
import com.cgs.gaexam.service.CourseService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/01/16.
 */
@Service
@Transactional
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {
    @Autowired
    private CourseMapper gaCourseMapper;

}
