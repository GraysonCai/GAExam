package com.cgs.gaexam.service;

import com.cgs.gaexam.core.Service;
import com.cgs.gaexam.model.UserExamRecord;
import com.cgs.gaexam.model.dto.*;

import java.util.Date;
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
     * 通过用户（教师）找到待阅卷的试卷
     *
     * @param userId
     * @return
     */
    List<UserExamRecordInfo> findWaitToReadPaperByUser(long userId);

    /**
     * 查找某个考试学生未过期和未进行的考试
     *
     * @param userId
     * @return
     */
    List<UserExamRecordInfo> findUserExamRecordInfo(long userId);

    /**
     * 查找学生考试历史记录（考试结束时间大于当前时间）
     *
     * @param userId
     * @return
     */
    List<UserExamRecordInfo> findUserHistoryExamRecordInfo(long userId);

    /**
     * 查找学生某个考试历史记录详情（考试结束时间大于当前时间）
     *
     * @param recordId
     * @return
     */
    UserExamRecordInfo getUserHistoryExamRecordDetailInfo(long recordId);

    /**
     * 更新答题卡和更新考试状态，并计算主观题分数，如果试卷都是主观题则直接算出分数
     * 记录学生作答情况
     *
     * @param userExamRecord
     */
    void submitAnswerSheet(UserExamRecord userExamRecord);

    /**
     * 阅卷，设置考生考试记录为已完成，同时更新考试记录中客观题总得分和考试答题记录中每道客观题的得分
     *
     * @param readExamInfo
     */
    void submitMarkScore(ReadExamInfo readExamInfo);

    /**
     * 获取成绩分布（饼状图）的设置项
     *
     * @param userId
     * @param examId
     * @return
     */
    PieChartOption getPieChartOption(long userId, long examId);

    /**
     * 获取用户各科成绩分布的设置项
     *
     * @param userId
     * @return
     */
    BarChartOption getBarChartOption(long userId);

    /**
     * 获取用户各科成绩分布的设置项
     *
     * @param userId
     * @return
     */
    LineChartOption getLineChartOption(long userId);

}
