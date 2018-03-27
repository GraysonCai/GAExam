package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.QuestionTypeMapper;
import com.cgs.gaexam.model.QuestionType;
import com.cgs.gaexam.service.QuestionTypeService;
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
public class QuestionTypeServiceImpl extends AbstractService<QuestionType> implements QuestionTypeService {
    @Autowired
    private QuestionTypeMapper gaQuestionTypeMapper;

}
