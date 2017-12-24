package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_role")
public class Role {
    /**
     * 角色标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色的权限
     */
    private String authority;

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
     * 获取角色标识
     *
     * @return id - 角色标识
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置角色标识
     *
     * @param id 角色标识
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色的权限
     *
     * @return authority - 角色的权限
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * 设置角色的权限
     *
     * @param authority 角色的权限
     */
    public void setAuthority(String authority) {
        this.authority = authority;
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