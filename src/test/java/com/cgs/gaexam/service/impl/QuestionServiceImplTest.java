package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.Tester;
import com.cgs.gaexam.model.dto.QuestionInfo;
import com.cgs.gaexam.service.QuestionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class QuestionServiceImplTest extends Tester {

    @Autowired
    private QuestionService questionService;

    @Test
    public void testFindAllQuestionInfo() {
        List<QuestionInfo> questionInfoList = questionService.findAllQuestionInfo();
        questionInfoList.forEach(questionInfo -> {
            System.out.println(questionInfo);
        });
    }


    @Test
    public void getQuestionInfoById() {
        Long id = 15L;
        QuestionInfo questionInfo = questionService.getQuestionInfoById(id);
        System.out.println(questionInfo);
    }
}