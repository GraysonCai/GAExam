package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.Question;
import com.cgs.gaexam.model.dto.QuestionInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper extends Mapper<Question> {
    List<QuestionInfo> findAllQuestionInfo();

    List<QuestionInfo> findQuestionInfoByIds(@Param("ids") String[] ids);

    List<QuestionInfo> findTestQuestionInfoByIds(@Param("ids") String[] ids);

    QuestionInfo getQuestionInfoById(@Param("id") Long questionId);

    QuestionInfo[] find(@Param("typeId") Long typeId, @Param("courseId") Long courseId, @Param("knowledgeIds") String knowledgeIds);

    QuestionInfo[] findExcludeQuestion(@Param("id") Long questionId, @Param("typeId") Long typeId,
                                       @Param("courseId") Long courseId, @Param("knowledgeIds") String knowledgeIds);
}