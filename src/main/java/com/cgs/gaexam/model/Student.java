package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_student")
public class Student {
    /**
     * 学员id
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
     * 第几届
     */
    private String grade;

    /**
     * 班级id
     */
    @Column(name = "class_id")
    private Long classId;

    /**
     * 学院id
     */
    @Column(name = "academy_id")
    private Long academyId;

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
     * 获取学员id
     *
     * @return id - 学员id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置学员id
     *
     * @param id 学员id
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
     * 获取第几届
     *
     * @return grade - 第几届
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置第几届
     *
     * @param grade 第几届
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 获取班级id
     *
     * @return class_id - 班级id
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * 设置班级id
     *
     * @param classId 班级id
     */
    public void setClassId(Long classId) {
        this.classId = classId;
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

    public Student(Long userId, String grade, Long classId, Long academyId, Date createDate, Long createBy) {
        this.userId = userId;
        this.grade = grade;
        this.classId = classId;
        this.academyId = academyId;
        this.createDate = createDate;
        this.createBy = createBy;
    }

    public Student(Long studentId, String grade, Long classId, Long academyId) {
        this.id = studentId;
        this.grade = grade;
        this.classId = classId;
        this.academyId = academyId;
    }

    public Student() {
    }
}