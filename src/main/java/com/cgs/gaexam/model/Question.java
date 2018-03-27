package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_question")
public class Question {
    /**
     * 试题id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 试题名称
     */
    private String stem;

    /**
     * 试题类型id
     */
    @Column(name = "question_type_id")
    private Long questionTypeId;

    /**
     * 所属课程id
     */
    @Column(name = "course_id")
    private Long courseId;

    /**
     * 知识点id，格式为1,2,3
     */
    @Column(name = "knowledge_ids")
    private String knowledgeIds;

    /**
     * 难度系数
     */
    private Float difficulty;

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
     * 试题内容
     */
    private String content;

    /**
     * 试题答案
     */
    private String answer;

    /**
     * 答案解析
     */
    private String analysis;

    /**
     * 获取试题id
     *
     * @return id - 试题id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置试题id
     *
     * @param id 试题id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取试题名称
     *
     * @return stem - 试题名称
     */
    public String getStem() {
        return stem;
    }

    /**
     * 设置试题名称
     *
     * @param stem 试题名称
     */
    public void setStem(String stem) {
        this.stem = stem;
    }

    /**
     * 获取试题类型id
     *
     * @return question_type_id - 试题类型id
     */
    public Long getQuestionTypeId() {
        return questionTypeId;
    }

    /**
     * 设置试题类型id
     *
     * @param questionTypeId 试题类型id
     */
    public void setQuestionTypeId(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
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
     * 获取试题内容
     *
     * @return content - 试题内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置试题内容
     *
     * @param content 试题内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取试题答案
     *
     * @return answer - 试题答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置试题答案
     *
     * @param answer 试题答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取答案解析
     *
     * @return analysis - 答案解析
     */
    public String getAnalysis() {
        return analysis;
    }

    /**
     * 设置答案解析
     *
     * @param analysis 答案解析
     */
    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", stem='" + stem + '\'' +
                ", questionTypeId=" + questionTypeId +
                ", courseId=" + courseId +
                ", knowledgeIds='" + knowledgeIds + '\'' +
                ", difficulty=" + difficulty +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", content='" + content + '\'' +
                ", answer='" + answer + '\'' +
                ", analysis='" + analysis + '\'' +
                '}';
    }
}