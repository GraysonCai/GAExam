package com.cgs.gaexam.service;

import com.cgs.gaexam.core.Service;
import com.cgs.gaexam.model.UserExamRecord;
import com.cgs.gaexam.model.dto.UserExamRecordInfo;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/21.
 */
public interface UserExamRecordService extends Service<UserExamRecord> {

    /**
     * 查找某场考试学生的考试记录
     *
     * @param examId
     * @return
     */
    List<UserExamRecordInfo> findAllExamRecordInfo(long examId);

    /**
     * 查找某个考试学生未过期和未进行的考试
     *
     * @param userId
     * @return
     */
    List<UserExamRecordInfo> findUserExamRecordInfo(long userId);
}
