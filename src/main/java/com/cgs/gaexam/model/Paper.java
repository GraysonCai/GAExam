package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_paper")
public class Paper {
    /**
     * 试卷id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 试卷名称
     */
    @Column(name = "paper_name")
    private String paperName;

    /**
     * 试题id，格式为1,2,3
     */
    @Column(name = "question_ids")
    private String questionIds;

    /**
     * 建议考试时长
     */
    private Integer duration;

    /**
     * 试卷及格分
     */
    @Column(name = "pass_score")
    private Float passScore;

    /**
     * 试卷状态，0未完成 -> 1已完成 -> 2已发布 （已发布的无法再修改）
     */
    private Byte status;

    /**
     * 为1表示为包含主观题的试卷，需阅卷
     */
    private Byte subjective;

    /**
     * 试卷描述
     */
    private String description;

    /**
     * 难度系数
     */
    private Float difficulty;

    /**
     * 适应度
     */
    @Column(name = "adaptation_degree")
    private Float adaptationDegree;

    /**
     * 所属课程id
     */
    @Column(name = "course_id")
    private Long courseId;

    /**
     * 所属课程id
     */
    @Column(name = "rule_id")
    private Long ruleId;

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
     * 知识点id，格式为1,2,3
     */
    @Column(name = "knowledge_ids")
    private String knowledgeIds;

    /**
     * 知识点覆盖率
     */
    @Column(name = "knowledge_coverage")
    private Float knowledgeCoverage;

    /**
     * 获取知识点覆盖率
     *
     * @return knowledgeCoverage - 知识点覆盖率
     */
    public Float getKnowledgeCoverage() {
        return knowledgeCoverage;
    }

    /**
     * 获取知识点覆盖率
     *
     * @param knowledgeCoverage - 知识点覆盖率
     */
    public void setKnowledgeCoverage(Float knowledgeCoverage) {
        this.knowledgeCoverage = knowledgeCoverage;
    }

    /**
     * 获取试卷id
     *
     * @return id - 试卷id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置试卷id
     *
     * @param id 试卷id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取试卷名称
     *
     * @return paper_name - 试卷名称
     */
    public String getPaperName() {
        return paperName;
    }

    /**
     * 设置试卷名称
     *
     * @param paperName 试卷名称
     */
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    /**
     * 获取试题id，格式为1,2,3
     *
     * @return question_ids - 试题id，格式为1,2,3
     */
    public String getQuestionIds() {
        return questionIds;
    }

    /**
     * 设置试题id，格式为1,2,3
     *
     * @param questionIds 试题id，格式为1,2,3
     */
    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds;
    }

    /**
     * 获取建议考试时长
     *
     * @return duration - 建议考试时长
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 设置建议考试时长
     *
     * @param duration 建议考试时长
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 获取试卷及格分
     *
     * @return pass_score - 试卷及格分
     */
    public Float getPassScore() {
        return passScore;
    }

    /**
     * 设置试卷及格分
     *
     * @param passScore 试卷及格分
     */
    public void setPassScore(Float passScore) {
        this.passScore = passScore;
    }

    /**
     * 获取试卷状态，0未完成 -> 1已完成 -> 2已发布 （已发布的无法再修改）
     *
     * @return status - 试卷状态，0未完成 -> 1已完成 -> 2已发布 （已发布的无法再修改）
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置试卷状态，0未完成 -> 1已完成 -> 2已发布 （已发布的无法再修改）
     *
     * @param status 试卷状态，0未完成 -> 1已完成 -> 2已发布 （已发布的无法再修改）
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取为1表示为包含主观题的试卷，需阅卷
     *
     * @return subjective - 为1表示为包含主观题的试卷，需阅卷
     */
    public Byte getSubjective() {
        return subjective;
    }

    /**
     * 设置为1表示为包含主观题的试卷，需阅卷
     *
     * @param subjective 为1表示为包含主观题的试卷，需阅卷
     */
    public void setSubjective(Byte subjective) {
        this.subjective = subjective;
    }

    /**
     * 获取试卷描述
     *
     * @return description - 试卷描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置试卷描述
     *
     * @param description 试卷描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取难度系数
     *
     * @return difficulty - 难度系数
     */
    public Float getDifficulty() {
        return difficulty;
    }

    /**
     * 设置难度系数
     *
     * @param difficulty 难度系数
     */
    public void setDifficulty(Float difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * 获取适应度
     *
     * @return adaptation_degree - 适应度
     */
    public Float getAdaptationDegree() {
        return adaptationDegree;
    }

    /**
     * 设置适应度
     *
     * @param adaptationDegree 适应度
     */
    public void setAdaptationDegree(Float adaptationDegree) {
        this.adaptationDegree = adaptationDegree;
    }

    /**
     * 获取所属课程id
     *
     * @return course_id - 所属课程id
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * 设置所属课程id
     *
     * @param courseId 所属课程id
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取所属课程id
     *
     * @return rule_id - 所属课程id
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 设置所属课程id
     *
     * @param ruleId 所属课程id
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
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
     * 获取知识点id，格式为1,2,3
     *
     * @return knowledge_ids - 知识点id，格式为1,2,3
     */
    public String getKnowledgeIds() {
        return knowledgeIds;
    }

    /**
     * 设置知识点id，格式为1,2,3
     *
     * @param knowledgeIds 知识点id，格式为1,2,3
     */
    public void setKnowledgeIds(String knowledgeIds) {
        this.knowledgeIds = knowledgeIds;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", paperName='" + paperName + '\'' +
                ", questionIds='" + questionIds + '\'' +
                ", duration=" + duration +
                ", passScore=" + passScore +
                ", status=" + status +
                ", subjective=" + subjective +
                ", description='" + description + '\'' +
                ", difficulty=" + difficulty +
                ", adaptationDegree=" + adaptationDegree +
                ", courseId=" + courseId +
                ", ruleId=" + ruleId +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", knowledgeIds='" + knowledgeIds + '\'' +
                ", knowledgeCoverage=" + knowledgeCoverage +
                '}';
    }
}