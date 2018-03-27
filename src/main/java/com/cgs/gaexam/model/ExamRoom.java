package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_exam_room")
public class ExamRoom {
    /**
     * 考场id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 座位数
     */
    private Integer seating;

    /**
     * 考场编号
     */
    @Column(name = "room_no")
    private String roomNo;

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
     * 获取考场id
     *
     * @return id - 考场id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置考场id
     *
     * @param id 考场id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取座位数
     *
     * @return seating - 座位数
     */
    public Integer getSeating() {
        return seating;
    }

    /**
     * 设置座位数
     *
     * @param seating 座位数
     */
    public void setSeating(Integer seating) {
        this.seating = seating;
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