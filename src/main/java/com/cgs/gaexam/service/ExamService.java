package com.cgs.gaexam.service;

import com.cgs.gaexam.model.Exam;
import com.cgs.gaexam.core.Service;
import com.cgs.gaexam.model.dto.ExamInfo;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/03/20.
 */
public interface ExamService extends Service<Exam> {

    /**
     * 获取所有的考试信息
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
    ExamInfo getExamInfoById(long examId);

    /**
     * 保存并发布考试
     *
     * @param exam
     */
    void saveAndPublish(Exam exam);

    /**
     * 修改并发布考试
     *
     * @param exam
     */
    void updateAndPublish(Exam exam);

    /**
     * 通过id进行发布
     *
     * @param examId
     */
    void publishById(long examId);

}
