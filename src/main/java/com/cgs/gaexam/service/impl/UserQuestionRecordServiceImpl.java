package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.UserQuestionRecordMapper;
import com.cgs.gaexam.model.UserQuestionRecord;
import com.cgs.gaexam.model.dto.UserQuestionRecordInfo;
import com.cgs.gaexam.service.UserQuestionRecordService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/28.
 */
@Service
@Transactional
public class UserQuestionRecordServiceImpl extends AbstractService<UserQuestionRecord> implements UserQuestionRecordService {
    @Autowired
    private UserQuestionRecordMapper gaUserQuestionRecordMapper;

    @Override
    public List<UserQuestionRecord> findQuestionRecordByUserAndExam(long userId, long examId) {
        UserQuestionRecord userQuestionRecord = new UserQuestionRecord();
        userQuestionRecord.setUserId(userId);
        userQuestionRecord.setExamId(examId);
        return gaUserQuestionRecordMapper.select(userQuestionRecord);
    }

    @Override
    public List<UserQuestionRecordInfo> findUserWrongQuestionRecord(long userId) {
        return gaUserQuestionRecordMapper.findUserWrongQuestionRecord(userId);
    }

    @Override
    public List<UserQuestionRecordInfo> findUserAllQuestionRecord(long userId) {
        return gaUserQuestionRecordMapper.findUserAllQuestionRecord(userId);
    }
}
