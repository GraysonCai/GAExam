package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.UserExamRecord;
import com.cgs.gaexam.model.dto.Data;
import com.cgs.gaexam.model.dto.UserExamRecordInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
     * 通过用户（教师）找到待阅卷的试卷
     *
     * @param userId
     * @return
     */
    List<UserExamRecordInfo> findWaitToReadPaperByUser(@Param("userId") long userId);

    /**
     * 查找某个考试学生未过期和未进行的考试
     *
     * @param userId
     * @return
     */
    List<UserExamRecordInfo> findUserExamRecordInfo(@Param("userId") long userId);

    /**
     * 查找学生考试历史记录（考试结束时间大于当前时间）
     *
     * @param userId
     * @return
     */
    List<UserExamRecordInfo> findUserHistoryExamRecordInfo(@Param("userId") long userId);

    /**
     * 查找学生某个考试历史记录详情（考试结束时间大于当前时间）
     *
     * @param recordId
     * @return
     */
    UserExamRecordInfo getUserHistoryExamRecordDetailInfo(@Param("recordId") long recordId);

    /**
     * 查找用户所属班级的考试情况
     *
     * @param userId
     * @param examId
     * @return
     */
    List<UserExamRecordInfo> findUserClassExamSituation(@Param("userId") long userId, @Param("examId") long examId);

    /**
     * 根据用户id查找完成的考试和成绩
     *
     * @param userId
     * @return
     */
    List<Data<Float>> findExamNameAndScore(@Param("userId") long userId);

    /**
     * 根据用户id和现在的时间查找结束的考试和排名
     *
     * @param userId
     * @param now
     * @return
     */
    List<Data<Integer>> findExamRank(@Param("userId") long userId, @Param("now") Date now);
}