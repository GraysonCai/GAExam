package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.UserExamRecord;
import com.cgs.gaexam.model.dto.UserExamRecordInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExamRecordMapper extends Mapper<UserExamRecord> {

    /**
     * 通过id查找考生考试信息
     *
     * @param examId
     * @return
     */
    List<UserExamRecordInfo> findAllExamRecordInfo(@Param("examId") long examId);

    /**
     * 查找某个考试学生未过期和未进行的考试
     *
     * @param userId
     * @return
     */
    List<UserExamRecordInfo> findUserExamRecordInfo(@Param("userId") long userId);
}