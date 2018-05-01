package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_user_exam_record")
public class UserExamRecord {
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
     * 试卷id
     */
    @Column(name = "paper_id")
    private Long paperId;

    /**
     * 考试id
     */
    @Column(name = "exam_id")
    private Long examId;

    /**
     * 考场编号
     */
    @Column(name = "exam_room_no")
    private String examRoomNo;

    /**
     * 考场座位号
     */
    @Column(name = "exam_seat_no")
    private Integer examSeatNo;

    /**
     * 考试状态, ，0未参与考试 ,1等待考试，2考试进行中，3考试中途退出, 4考试完成
     */
    private Byte status;

    /**
     * 考试结果，0不及格，1及格
     */
    private Byte result;

    /**
     * 主观题得分
     */
    @Column(name = "subjective_score")
    private Float subjectiveScore;

    /**
     * 客观题得分
     */
    @Column(name = "objective_score")
    private Float objectiveScore;

    /**
     * 开始考试时间
     */
    @Column(name = "begin_date")
    private Date beginDate;

    /**
     * 结束考试时间
     */
    @Column(name = "finished_date")
    private Date finishedDate;

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
     * 答题卡
     */
    @Column(name = "answer_sheet")
    private String answerSheet;

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
     * 获取试卷id
     *
     * @return paper_id - 试卷id
     */
    public Long getPaperId() {
        return paperId;
    }

    /**
     * 设置试卷id
     *
     * @param paperId 试卷id
     */
    public void setPaperId(Long paperId) {
        this.paperId = paperId;
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
     * 获取考场编号
     *
     * @return exam_room_no - 考场编号
     */
    public String getExamRoomNo() {
        return examRoomNo;
    }

    /**
     * 设置考场编号
     *
     * @param examRoomNo 考场编号
     */
    public void setExamRoomNo(String examRoomNo) {
        this.examRoomNo = examRoomNo;
    }

    /**
     * 获取考场座位号
     *
     * @return exam_seat_no - 考场座位号
     */
    public Integer getExamSeatNo() {
        return examSeatNo;
    }

    /**
     * 设置考场座位号
     *
     * @param examSeatNo 考场座位号
     */
    public void setExamSeatNo(Integer examSeatNo) {
        this.examSeatNo = examSeatNo;
    }

    /**
     * 获取考试状态, ，0未参与考试 ,1等待考试，2考试进行中，3考试中途退出, 4考试完成
     *
     * @return status - 考试状态, ，0未参与考试 ,1等待考试，2考试进行中，3考试中途退出, 4考试完成
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置考试状态, ，0未参与考试 ,1等待考试，2考试进行中，3考试中途退出, 4考试完成
     *
     * @param status 考试状态, ，0未参与考试 ,1等待考试，2考试进行中，3考试中途退出, 4考试完成
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取考试结果，0不及格，1及格
     *
     * @return result - 考试结果，0不及格，1及格
     */
    public Byte getResult() {
        return result;
    }

    /**
     * 设置考试结果，0不及格，1及格
     *
     * @param result 考试结果，0不及格，1及格
     */
    public void setResult(Byte result) {
        this.result = result;
    }

    /**
     * 获取主观题得分
     *
     * @return subjective_score - 主观题得分
     */
    public Float getSubjectiveScore() {
        return subjectiveScore;
    }

    /**
     * 设置主观题得分
     *
     * @param subjectiveScore 主观题得分
     */
    public void setSubjectiveScore(Float subjectiveScore) {
        this.subjectiveScore = subjectiveScore;
    }

    /**
     * 获取客观题得分
     *
     * @return objective_score - 客观题得分
     */
    public Float getObjectiveScore() {
        return objectiveScore;
    }

    /**
     * 设置客观题得分
     *
     * @param objectiveScore 客观题得分
     */
    public void setObjectiveScore(Float objectiveScore) {
        this.objectiveScore = objectiveScore;
    }

    /**
     * 获取开始考试时间
     *
     * @return begin_date - 开始考试时间
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 设置开始考试时间
     *
     * @param beginDate 开始考试时间
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取结束考试时间
     *
     * @return finished_date - 结束考试时间
     */
    public Date getFinishedDate() {
        return finishedDate;
    }

    /**
     * 设置结束考试时间
     *
     * @param finishedDate 结束考试时间
     */
    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
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
     * 获取答题卡
     *
     * @return answer_sheet - 答题卡
     */
    public String getAnswerSheet() {
        return answerSheet;
    }

    /**
     * 设置答题卡
     *
     * @param answerSheet 答题卡
     */
    public void setAnswerSheet(String answerSheet) {
        this.answerSheet = answerSheet;
    }

    public UserExamRecord() {
    }

    public UserExamRecord(Long userId, Long paperId, Long examId, String examRoomNo, Integer examSeatNo, Byte status, Byte result, Date createDate, Long createBy) {
        this.userId = userId;
        this.paperId = paperId;
        this.examId = examId;
        this.examRoomNo = examRoomNo;
        this.examSeatNo = examSeatNo;
        this.status = status;
        this.result = result;
        this.createDate = createDate;
        this.createBy = createBy;
    }

    public UserExamRecord(Long userId, Long paperId, Long examId, String examRoomNo, Integer examSeatNo, Byte status, Byte result, Float subjectiveScore, Float objectiveScore, Date beginDate, Date finishedDate, Date createDate, Long createBy, String answerSheet) {
        this.userId = userId;
        this.paperId = paperId;
        this.examId = examId;
        this.examRoomNo = examRoomNo;
        this.examSeatNo = examSeatNo;
        this.status = status;
        this.result = result;
        this.subjectiveScore = subjectiveScore;
        this.objectiveScore = objectiveScore;
        this.beginDate = beginDate;
        this.finishedDate = finishedDate;
        this.createDate = createDate;
        this.createBy = createBy;
        this.answerSheet = answerSheet;
    }

    @Override
    public String toString() {
        return "UserExamRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", paperId=" + paperId +
                ", examId=" + examId +
                ", examRoomNo='" + examRoomNo + '\'' +
                ", examSeatNo=" + examSeatNo +
                ", status=" + status +
                ", result=" + result +
                ", subjectiveScore=" + subjectiveScore +
                ", objectiveScore=" + objectiveScore +
                ", beginDate=" + beginDate +
                ", finishedDate=" + finishedDate +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", answerSheet='" + answerSheet + '\'' +
                '}';
    }
}