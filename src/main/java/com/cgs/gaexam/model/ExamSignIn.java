package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_exam_sign_in")
public class ExamSignIn {
    /**
     * 记录id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 考试id
     */
    @Column(name = "exam_id")
    private Long examId;

    /**
     * 考场编号
     */
    @Column(name = "room_no")
    private String roomNo;

    /**
     * 卡号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 学生id
     */
    @Column(name = "student_id")
    private Long studentId;

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
     * @return room_no - 考场编号
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 设置考场编号
     *
     * @param roomNo 考场编号
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * 获取卡号
     *
     * @return card_no - 卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置卡号
     *
     * @param cardNo 卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取学生id
     *
     * @return student_id - 学生id
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * 设置学生id
     *
     * @param studentId 学生id
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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
}