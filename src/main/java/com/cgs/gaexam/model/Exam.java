package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_exam")
public class Exam {
    /**
     * 考试id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 考试名称
     */
    @Column(name = "exam_name")
    private String examName;

    /**
     * 试卷id
     */
    @Column(name = "paper_id")
    private Long paperId;

    /**
     * 考试状态，0未开始->1进行中->2已结束
     */
    private Byte status;

    /**
     * 考试开始时间
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 考试结束时间
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 考场id
     */
    @Column(name = "exam_room_ids")
    private String examRoomIds;

    /**
     * 班级id，格式为1,2,3
     */
    @Column(name = "exam_classes")
    private String examClasses;

    /**
     * 考试总人数
     */
    @Column(name = "total_exam_number")
    private int totalExamNumber;

    /**
     * 考场总容量
     */
    @Column(name = "exam_room_capacity")
    private int examRoomCapacity;

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
     * 获取考试id
     *
     * @return id - 考试id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置考试id
     *
     * @param id 考试id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取考试名称
     *
     * @return exam_name - 考试名称
     */
    public String getExamName() {
        return examName;
    }

    /**
     * 设置考试名称
     *
     * @param examName 考试名称
     */
    public void setExamName(String examName) {
        this.examName = examName;
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
     * 获取考试状态，0未开始->1进行中->2已结束
     *
     * @return status - 考试状态，0未开始->1进行中->2已结束
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置考试状态，0未开始->1进行中->2已结束
     *
     * @param status 考试状态，0未开始->1进行中->2已结束
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取考试开始时间
     *
     * @return start_date - 考试开始时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置考试开始时间
     *
     * @param startDate 考试开始时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取考试结束时间
     *
     * @return end_date - 考试结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置考试结束时间
     *
     * @param endDate 考试结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取考场id
     *
     * @return exam_room_ids - 考场id
     */
    public String getExamRoomIds() {
        return examRoomIds;
    }

    /**
     * 设置考场id
     *
     * @param examRoomIds 考场id
     */
    public void setExamRoomIds(String examRoomIds) {
        this.examRoomIds = examRoomIds;
    }

    /**
     * 获取班级id，格式为1,2,3
     *
     * @return exam_classes - 班级id，格式为1,2,3
     */
    public String getExamClasses() {
        return examClasses;
    }

    /**
     * 设置班级id，格式为1,2,3
     *
     * @param examClasses 班级id，格式为1,2,3
     */
    public void setExamClasses(String examClasses) {
        this.examClasses = examClasses;
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

    public int getTotalExamNumber() {
        return totalExamNumber;
    }

    public void setTotalExamNumber(int totalExamNumber) {
        this.totalExamNumber = totalExamNumber;
    }

    public int getExamRoomCapacity() {
        return examRoomCapacity;
    }

    public void setExamRoomCapacity(int examRoomCapacity) {
        this.examRoomCapacity = examRoomCapacity;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", paperId=" + paperId +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", examRoomIds=" + examRoomIds +
                ", examClasses='" + examClasses + '\'' +
                ", totalExamNumber=" + totalExamNumber +
                ", examRoomCapacity=" + examRoomCapacity +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                '}';
    }
}