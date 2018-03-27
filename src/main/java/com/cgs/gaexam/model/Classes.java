package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_class")
public class Classes {
    /**
     * 班级id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 班级名称
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 所属学院
     */
    @Column(name = "academy_id")
    private Long academyId;

    /**
     * 所属学院
     */
    @Column(name = "student_number")
    private int studentNumber;

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
     * 获取班级id
     *
     * @return id - 班级id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置班级id
     *
     * @param id 班级id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取班级名称
     *
     * @return class_name - 班级名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置班级名称
     *
     * @param className 班级名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取所属学院
     *
     * @return academy_id - 所属学院
     */
    public Long getAcademyId() {
        return academyId;
    }


    /**
     * 设置所属学院
     *
     * @param academyId 所属学院
     */
    public void setAcademyId(Long academyId) {
        this.academyId = academyId;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
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