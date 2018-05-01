package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.*;
import com.cgs.gaexam.model.Student;
import com.cgs.gaexam.model.dto.SiteStat;
import com.cgs.gaexam.service.SiteStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteStatServiceImpl implements SiteStatService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public SiteStat siteStat() {
        SiteStat siteStat = new SiteStat();
        siteStat.setExamNumber(examMapper.selectCount(null));
        siteStat.setPaperNumber(paperMapper.selectCount(null));
        siteStat.setQuestionNumber(questionMapper.selectCount(null));
        siteStat.setStudentNumber(studentMapper.selectCount(null));
        siteStat.setTeacherNumber(teacherMapper.selectCount(null));
        return siteStat;
    }
}
