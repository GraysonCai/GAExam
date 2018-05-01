package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.ExamSignInMapper;
import com.cgs.gaexam.model.ExamSignIn;
import com.cgs.gaexam.service.ExamSignInService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/04/26.
 */
@Service
@Transactional
public class ExamSignInServiceImpl extends AbstractService<ExamSignIn> implements ExamSignInService {
    @Autowired
    private ExamSignInMapper gaExamSignInMapper;

    @Override
    public int countSignIn(long examId, long userId) {
        ExamSignIn examSignIn = new ExamSignIn();
        examSignIn.setExamId(examId);
        examSignIn.setUserId(userId);
        return gaExamSignInMapper.selectCount(examSignIn);
    }
}
