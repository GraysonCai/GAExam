package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.Exam;
import com.cgs.gaexam.model.dto.ExamInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMapper extends Mapper<Exam> {

    /**
     * 获取数据库中所有考试信息
     *
     * @return
     */
    List<ExamInfo> findAllExamInfo();

    /**
     * 根据id获取考试信息
     *
     * @param examId
     * @return
     */
    ExamInfo getExamInfoById(@Param("examId") long examId);


}