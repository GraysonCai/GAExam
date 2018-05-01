package com.cgs.gaexam.service;

import com.cgs.gaexam.model.ExamSignIn;
import com.cgs.gaexam.core.Service;


/**
 * Created by CodeGenerator on 2018/04/26.
 */
public interface ExamSignInService extends Service<ExamSignIn> {

    int countSignIn(long examId, long userId);
}
