package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.dao.UserExamRecordMapper;
import com.cgs.gaexam.model.UserExamRecord;
import com.cgs.gaexam.model.dto.UserExamRecordInfo;
import com.cgs.gaexam.service.UserExamRecordService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/21.
 */
@Service
@Transactional
public class UserExamRecordServiceImpl extends AbstractService<UserExamRecord> implements UserExamRecordService {
    @Autowired
    private UserExamRecordMapper gaUserExamRecordMapper;

    @Override
    public List<UserExamRecordInfo> findUserExamRecordInfo(long userId) {
        return gaUserExamRecordMapper.findUserExamRecordInfo(userId);
    }

    @Override
    public List<UserExamRecordInfo> findAllExamRecordInfo(long examId) {
        List<UserExamRecordInfo> examRecords = gaUserExamRecordMapper.findAllExamRecordInfo(examId);
        for (UserExamRecordInfo examRecord : examRecords) {
            if (examRecord.getStatus() != null) {
                String status = ProjectConstant.getStudentExamStatus(examRecord.getStatus());
                examRecord.setStatusName(status);
            }
            if (examRecord.getResult() != null) {
                String result = ProjectConstant.getStudentExamResult(examRecord.getResult());
                examRecord.setResultName(result);
            }
            if (examRecord.getObjectiveScore() != null && examRecord.getSubjectiveScore() != null) {
                examRecord.setTotalScore(examRecord.getObjectiveScore() + examRecord.getSubjectiveScore());
            } else if (examRecord.getObjectiveScore() != null) {
                examRecord.setTotalScore(examRecord.getObjectiveScore());
            } else if (examRecord.getSubjectiveScore() != null) {
                examRecord.setTotalScore(examRecord.getSubjectiveScore());
            }
        }
        return examRecords;
    }
}
