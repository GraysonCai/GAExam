package com.cgs.gaexam.service;

import com.cgs.gaexam.model.Question;
import com.cgs.gaexam.core.Service;
import com.cgs.gaexam.model.dto.QuestionInfo;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/25.
 */
public interface QuestionService extends Service<Question> {

    /**
     * 查找所有试题信息
     *
     * @return
     */
    List<QuestionInfo> findAllQuestionInfo();

    /**
     * 通过id字符串和组卷规则查找试题信息列表
     *
     * @param ids
     * @return
     * @aram ruleId
     */
    List<QuestionInfo> findQuestionInfoByIds(String ids, Long ruleId);

    /**
     * 通过id字符串和组卷规则查找测试时的试题信息列表(防止暴露答案)
     *
     * @param ids
     * @return
     * @aram ruleId
     */
    List<QuestionInfo> findTestQuestionInfoByIds(String ids, Long ruleId);

    /**
     * 通过id查找试题信息
     *
     * @param questionId
     * @return
     */
    QuestionInfo getQuestionInfoById(Long questionId);


    /**
     * 通过试题记录id查找错题信息
     *
     * @param questionRecordId
     * @return
     */
    QuestionInfo getQuestionDetailById(long questionRecordId);

    /**
     * 通过课程和相应知识点查找特定题型的试题
     *
     * @param typeId
     * @param courseId
     * @param ids
     * @return
     */
    QuestionInfo[] find(Long typeId, Long courseId, String ids);


    /**
     * 通过课程和相应知识点查找排除某个试题的特定题型的试题
     *
     * @param questionId
     * @param typeId
     * @param courseId
     * @param ids
     * @return
     */
    QuestionInfo[] findExcludeQuestion(Long questionId, Long typeId, Long courseId, String ids);

}
