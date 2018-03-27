package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_question_type")
public class QuestionType {
    /**
     * 试题类型id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 试题类型名称
     */
    @Column(name = "type_name")
    private String typeName;

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
     * 获取试题类型id
     *
     * @return id - 试题类型id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置试题类型id
     *
     * @param id 试题类型id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取试题类型名称
     *
     * @return type_name - 试题类型名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置试题类型名称
     *
     * @param typeName 试题类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
}