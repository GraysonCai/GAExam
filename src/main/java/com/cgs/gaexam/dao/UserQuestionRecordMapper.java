package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.UserQuestionRecord;
import com.cgs.gaexam.model.dto.UserQuestionRecordInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQuestionRecordMapper extends Mapper<UserQuestionRecord> {


    /**
     * 查找用户错题记录
     *
     * @param userId
     * @return
     */
    List<UserQuestionRecordInfo> findUserWrongQuestionRecord(@Param("userId") long userId);

    /**
     * 查找用户做题记录
     *
     * @param userId
     * @return
     */
    List<UserQuestionRecordInfo> findUserAllQuestionRecord(@Param("userId") long userId);

    /**
     * 查找某人某场考试某些题目
     *
     * @param examId
     * @param userId
     * @param questionIds
     * @return
     */
    List<UserQuestionRecord> findBy(@Param("examId") long examId, @Param("userId") long userId, @Param("questionIds") List<Long> questionIds);
}