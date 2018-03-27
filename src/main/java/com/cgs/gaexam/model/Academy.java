package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_academy")
public class Academy {
    /**
     * 学院id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学院名称
     */
    @Column(name = "academy_name")
    private String academyName;

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
     * 获取学院id
     *
     * @return id - 学院id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置学院id
     *
     * @param id 学院id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取学院名称
     *
     * @return academy_name - 学院名称
     */
    public String getAcademyName() {
        return academyName;
    }

    /**
     * 设置学院名称
     *
     * @param academyName 学院名称
     */
    public void setAcademyName(String academyName) {
        this.academyName = academyName;
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