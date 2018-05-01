package com.cgs.gaexam.service;

import com.cgs.gaexam.model.UserQuestionRecord;
import com.cgs.gaexam.core.Service;
import com.cgs.gaexam.model.dto.UserQuestionRecordInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/28.
 */
public interface UserQuestionRecordService extends Service<UserQuestionRecord> {

    /**
     * 查找某人某次考试的答题记录
     *
     * @param userId
     * @param examId
     * @return
     */
    List<UserQuestionRecord> findQuestionRecordByUserAndExam(long userId, long examId);

    /**
     * 查找用户错题记录
     *
     * @param userId
     * @return
     */
    List<UserQuestionRecordInfo> findUserWrongQuestionRecord(long userId);

    /**
     * 查找用户所有的做题记录
     *
     * @param userId
     * @return
     */
    List<UserQuestionRecordInfo> findUserAllQuestionRecord(long userId);
}
