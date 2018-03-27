package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_teacher")
public class Teacher {
    /**
     * 教师id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 学院id
     */
    @Column(name = "academy_id")
    private Long academyId;

    /**
     * 职称
     */
    private String title;

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
     * 获取教师id
     *
     * @return id - 教师id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置教师id
     *
     * @param id 教师id
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取学院id
     *
     * @return academy_id - 学院id
     */
    public Long getAcademyId() {
        return academyId;
    }

    /**
     * 设置学院id
     *
     * @param academyId 学院id
     */
    public void setAcademyId(Long academyId) {
        this.academyId = academyId;
    }

    /**
     * 获取职称
     *
     * @return title - 职称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置职称
     *
     * @param title 职称
     */
    public void setTitle(String title) {
        this.title = title;
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

    public Teacher() {
    }

    //所有字段
    public Teacher(Long id, Long userId, Long academyId, String title, Date createDate, Long createBy) {
        this.id = id;
        this.userId = userId;
        this.academyId = academyId;
        this.title = title;
        this.createDate = createDate;
        this.createBy = createBy;
    }

    //插入数据
    public Teacher(Long userId, Long academyId, String title, Date createDate, Long createBy) {
        this.userId = userId;
        this.academyId = academyId;
        this.title = title;
        this.createDate = createDate;
        this.createBy = createBy;
    }

    //更新数据
    public Teacher(Long teacherId, Long academyId, String title) {
        this.id = teacherId;
        this.academyId = academyId;
        this.title = title;
    }
}