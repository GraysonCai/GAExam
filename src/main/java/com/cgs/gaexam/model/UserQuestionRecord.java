package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_user_question_record")
public class UserQuestionRecord {
    /**
     * 记录id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 考生id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 考试id
     */
    @Column(name = "exam_id")
    private Long examId;

    /**
     * 试题id
     */
    @Column(name = "question_id")
    private Long questionId;

    /**
     * 试题分数
     */
    @Column(name = "question_score")
    private Float questionScore;

    /**
     * 获得分数
     */
    @Column(name = "gain_score")
    private Float gainScore;

    /**
     * 是否正确, ，0不正确，1正确
     */
    @Column(name = "is_right")
    private Byte isRight;

    /**
     * 是否是主观题，0代表客观题，1代表主观题
     */
    private Byte subjective;

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
     * 获取记录id
     *
     * @return id - 记录id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置记录id
     *
     * @param id 记录id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取考生id
     *
     * @return user_id - 考生id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置考生id
     *
     * @param userId 考生id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取考试id
     *
     * @return exam_id - 考试id
     */
    public Long getExamId() {
        return examId;
    }

    /**
     * 设置考试id
     *
     * @param examId 考试id
     */
    public void setExamId(Long examId) {
        this.examId = examId;
    }

    /**
     * 获取试题id
     *
     * @return question_id - 试题id
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * 设置试题id
     *
     * @param questionId 试题id
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取试题分数
     *
     * @return question_score - 试题分数
     */
    public Float getQuestionScore() {
        return questionScore;
    }

    /**
     * 设置试题分数
     *
     * @param questionScore 试题分数
     */
    public void setQuestionScore(Float questionScore) {
        this.questionScore = questionScore;
    }

    /**
     * 获取获得分数
     *
     * @return gain_score - 获得分数
     */
    public Float getGainScore() {
        return gainScore;
    }

    /**
     * 设置获得分数
     *
     * @param gainScore 获得分数
     */
    public void setGainScore(Float gainScore) {
        this.gainScore = gainScore;
    }

    /**
     * 获取是否正确, ，0不正确，1正确
     *
     * @return isRight - 是否正确, ，0不正确，1正确
     */
    public Byte getIsRight() {
        return isRight;
    }

    /**
     * 设置是否正确, ，0不正确，1正确
     *
     * @param isRight 是否正确, ，0不正确，1正确
     */
    public void setIsRight(Byte isRight) {
        this.isRight = isRight;
    }

    /**
     * 获取是否是主观题，0代表客观题，1代表主观题
     *
     * @return subjective - 是否是主观题，0代表客观题，1代表主观题
     */
    public Byte getSubjective() {
        return subjective;
    }

    /**
     * 设置是否是主观题，0代表客观题，1代表主观题
     *
     * @param subjective 是否是主观题，0代表客观题，1代表主观题
     */
    public void setSubjective(Byte subjective) {
        this.subjective = subjective;
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

    public UserQuestionRecord() {
    }

    public UserQuestionRecord(Long userId, Long examId, Long questionId, Float questionScore, Float gainScore, Date createDate, Long createBy) {
        this.userId = userId;
        this.examId = examId;
        this.questionId = questionId;
        this.questionScore = questionScore;
        this.gainScore = gainScore;
        this.createDate = createDate;
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "UserQuestionRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", examId=" + examId +
                ", questionId=" + questionId +
                ", questionScore=" + questionScore +
                ", gainScore=" + gainScore +
                ", isRight=" + isRight +
                ", subjective=" + subjective +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                '}';
    }
}