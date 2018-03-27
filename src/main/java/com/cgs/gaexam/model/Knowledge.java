package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_knowledge")
public class Knowledge {

    public Knowledge(Long courseId) {
        this.courseId = courseId;
    }

    public Knowledge() {
    }

    /**
     * 知识点id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 知识点名称
     */
    @Column(name = "knowledge_name")
    private String knowledgeName;

    /**
     * 知识点所属课程
     */
    @Column(name = "course_id")
    private Long courseId;

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
     * 获取知识点id
     *
     * @return id - 知识点id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置知识点id
     *
     * @param id 知识点id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取知识点名称
     *
     * @return knowledge_name - 知识点名称
     */
    public String getKnowledgeName() {
        return knowledgeName;
    }

    /**
     * 设置知识点名称
     *
     * @param knowledgeName 知识点名称
     */
    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    /**
     * 获取知识点所属课程
     *
     * @return course_id - 知识点所属课程
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * 设置知识点所属课程
     *
     * @param courseId 知识点所属课程
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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