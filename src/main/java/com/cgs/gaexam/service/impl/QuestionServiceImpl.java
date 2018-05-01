package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.QuestionMapper;
import com.cgs.gaexam.dao.RuleMapper;
import com.cgs.gaexam.model.Question;
import com.cgs.gaexam.model.Rule;
import com.cgs.gaexam.model.dto.QuestionInfo;
import com.cgs.gaexam.model.dto.RuleInfo;
import com.cgs.gaexam.service.QuestionService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/01/25.
 */
@Service
@Transactional
public class QuestionServiceImpl extends AbstractService<Question> implements QuestionService {
    @Autowired
    private QuestionMapper gaQuestionMapper;

    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public List<QuestionInfo> findAllQuestionInfo() {
        return gaQuestionMapper.findAllQuestionInfo();
    }

    @Override
    public List<QuestionInfo> findQuestionInfoByIds(String ids, Long ruleId) {
        List<QuestionInfo> questionInfos = gaQuestionMapper.findQuestionInfoByIds(ids.split(","));
        Rule rule = ruleMapper.selectByPrimaryKey(ruleId);
        List<Map<String, Object>> typeMap = rule.getQuestionInfoMapList();
        Map<Long, Integer> scoreMap = new HashMap<>();
        for (Map<String, Object> map : typeMap) {
            scoreMap.put(Long.parseLong(map.get("typeId").toString()), Integer.valueOf(map.get("score").toString()));
        }
        for (QuestionInfo questionInfo : questionInfos) {
            Long typeId = questionInfo.getQuestionTypeId();
            if (scoreMap.containsKey(typeId)) {
                questionInfo.setScore(scoreMap.get(typeId));
            }
        }
        return questionInfos;
    }

    @Override
    public List<QuestionInfo> findTestQuestionInfoByIds(String ids, Long ruleId) {
        List<QuestionInfo> questionInfos = gaQuestionMapper.findTestQuestionInfoByIds(ids.split(","));
        Rule rule = ruleMapper.selectByPrimaryKey(ruleId);
        List<Map<String, Object>> typeMap = rule.getQuestionInfoMapList();
        Map<Long, Integer> scoreMap = new HashMap<>();
        for (Map<String, Object> map : typeMap) {
            scoreMap.put(Long.parseLong(map.get("typeId").toString()), Integer.valueOf(map.get("score").toString()));
        }
        for (QuestionInfo questionInfo : questionInfos) {
            Long typeId = questionInfo.getQuestionTypeId();
            if (scoreMap.containsKey(typeId)) {
                questionInfo.setScore(scoreMap.get(typeId));
            }
        }
        return questionInfos;
    }

    @Override
    public QuestionInfo getQuestionDetailById(long questionRecordId) {
        return gaQuestionMapper.getQuestionDetailById(questionRecordId);
    }

    @Override
    public QuestionInfo getQuestionInfoById(Long questionId) {
        return gaQuestionMapper.getQuestionInfoById(questionId);
    }

    @Override
    public QuestionInfo[] find(Long typeId, Long courseId, String knowledgeIds) {
        return gaQuestionMapper.find(typeId, courseId, knowledgeIds);
    }

    @Override
    public QuestionInfo[] findExcludeQuestion(Long questionId, Long typeId, Long courseId, String knowledgeIds) {
        return gaQuestionMapper.findExcludeQuestion(questionId, typeId, courseId, knowledgeIds);
    }

}
