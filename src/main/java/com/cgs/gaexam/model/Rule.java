package com.cgs.gaexam.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import javax.persistence.*;

@Table(name = "ga_rule")
public class Rule {
    /**
     * 规则id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 组卷方式，0为手动，1为自动
     */
    @Column(name = "rule_type")
    private Byte ruleType;

    /**
     * 试卷总分
     */
    @Column(name = "total_score")
    private Float totalScore;

    /**
     * 期望难度系数
     */
    @Column(name = "exp_difficulty")
    private Float expDifficulty;

    /**
     * 期望覆盖知识点id，格式为1,2,3
     */
    @Column(name = "exp_knowledge_ids")
    private String expKnowledgeIds;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Long createBy;

    /**
     * 试题信息，根据组卷方式有不同格式，手动组卷包含（questionId,questionType,score），自动组卷包括（questionType, number，score）
     */
    @Column(name = "question_info")
    private String questionInfo;

    @Column(name = "course_id")
    private Long courseId;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取规则id
     *
     * @return id - 规则id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置规则id
     *
     * @param id 规则id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取组卷方式，0为手动，1为自动
     *
     * @return rule_type - 组卷方式，0为手动，1为自动
     */
    public Byte getRuleType() {
        return ruleType;
    }

    /**
     * 设置组卷方式，0为手动，1为自动
     *
     * @param ruleType 组卷方式，0为手动，1为自动
     */
    public void setRuleType(Byte ruleType) {
        this.ruleType = ruleType;
    }

    /**
     * 获取试卷总分
     *
     * @return total_score - 试卷总分
     */
    public Float getTotalScore() {
        return totalScore;
    }

    /**
     * 设置试卷总分
     *
     * @param totalScore 试卷总分
     */
    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * 获取期望难度系数
     *
     * @return exp_difficulty - 期望难度系数
     */
    public Float getExpDifficulty() {
        return expDifficulty;
    }

    /**
     * 设置期望难度系数
     *
     * @param expDifficulty 期望难度系数
     */
    public void setExpDifficulty(Float expDifficulty) {
        this.expDifficulty = expDifficulty;
    }

    /**
     * 获取期望覆盖知识点id，格式为1,2,3
     *
     * @return exp_knowledge_ids - 期望覆盖知识点id，格式为1,2,3
     */
    public String getExpKnowledgeIds() {
        return expKnowledgeIds;
    }

    /**
     * 设置期望覆盖知识点id，格式为1,2,3
     *
     * @param expKnowledgeIds 期望覆盖知识点id，格式为1,2,3
     */
    public void setExpKnowledgeIds(String expKnowledgeIds) {
        this.expKnowledgeIds = expKnowledgeIds;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取试题信息，根据组卷方式有不同格式，手动组卷包含（questionId,questionType,score），自动组卷包括（questionType, number，score）
     *
     * @return question_info - 试题信息，根据组卷方式有不同格式，手动组卷包含（questionId,questionType,score），自动组卷包括（questionType, number，score）
     */
    public String getQuestionInfo() {
        return questionInfo;
    }

    /**
     * 设置试题信息，根据组卷方式有不同格式，手动组卷包含（questionId,questionType,score），自动组卷包括（questionType, number，score）
     *
     * @param questionInfo 试题信息，根据组卷方式有不同格式，手动组卷包含（questionId,questionType,score），自动组卷包括（questionType, number，score）
     */
    public void setQuestionInfo(String questionInfo) {
        this.questionInfo = questionInfo;
    }

    public Rule(Byte ruleType, Float totalScore, Float expDifficulty, String expKnowledgeIds, Date createDate, Long createBy, String questionInfo, Long courseId) {
        this.ruleType = ruleType;
        this.totalScore = totalScore;
        this.expDifficulty = expDifficulty;
        this.expKnowledgeIds = expKnowledgeIds;
        this.createDate = createDate;
        this.createBy = createBy;
        this.questionInfo = questionInfo;
        this.courseId = courseId;
    }

    public Rule() {
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", ruleType=" + ruleType +
                ", totalScore=" + totalScore +
                ", expDifficulty=" + expDifficulty +
                ", expKnowledgeIds='" + expKnowledgeIds + '\'' +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", questionInfo='" + questionInfo + '\'' +
                ", courseId=" + courseId +
                '}';
    }

    public List<Map<String, Object>> getQuestionInfoMapList() {
        if (questionInfo != null) {
            List<Map<String, Object>> mapList = new ArrayList<>();
            JSONArray questionTypeInfoList = JSONArray.parseArray(questionInfo);
            if (questionTypeInfoList.size() > 0) {
                Map<String, Object> questionMap;
                for (int i = 0; i < questionTypeInfoList.size(); i++) {
                    JSONObject questionTypeInfo = questionTypeInfoList.getJSONObject(i);
                    long questionType = questionTypeInfo.getLong("typeId");
                    int score = questionTypeInfo.getInteger("score");
                    int number = questionTypeInfo.getInteger("number");
                    String typeName = questionTypeInfo.getString("typeName");

                    questionMap = new HashMap<>();
                    questionMap.put("typeId", questionType);
                    questionMap.put("score", score);
                    questionMap.put("number", number);
                    questionMap.put("typeName", typeName);
                    mapList.add(questionMap);
                }
            }
            return mapList;
        }
        return null;
    }

    public int getQuestionNumberByTypeId(long typeId) {
        List<Map<String, Object>> list = getQuestionInfoMapList();
        int number = 0;
        if (list != null && list.size() > 0) {
            for (Map<String, Object> map : list) {
                if (typeId == Long.valueOf(map.get("typeId").toString())) {
                    return Integer.valueOf(map.get("number").toString());
                }
            }
        }
        return number;
    }

}