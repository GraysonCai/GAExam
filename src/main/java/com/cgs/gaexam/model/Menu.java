package com.cgs.gaexam.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ga_menu")
public class Menu {
    /**
     * 菜单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父菜单id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 菜单主题
     */
    private String title;

    /**
     * 菜单描述
     */
    private String description;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 对应菜单组件
     */
    private String component;

    /**
     * 菜单网址（比如百度）
     */
    private String url;

    /**
     * 按钮图标
     */
    private String icon;

    /**
     * 菜单排序
     */
    private Integer sort;

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
     * 获取菜单id
     *
     * @return id - 菜单id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置菜单id
     *
     * @param id 菜单id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取父菜单id
     *
     * @return parent_id - 父菜单id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单id
     *
     * @param parentId 父菜单id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取菜单主题
     *
     * @return title - 菜单主题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置菜单主题
     *
     * @param title 菜单主题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取菜单描述
     *
     * @return description - 菜单描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置菜单描述
     *
     * @param description 菜单描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取菜单路径
     *
     * @return path - 菜单路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置菜单路径
     *
     * @param path 菜单路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取对应菜单组件
     *
     * @return component - 对应菜单组件
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置对应菜单组件
     *
     * @param component 对应菜单组件
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取菜单网址（比如百度）
     *
     * @return url - 菜单网址（比如百度）
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单网址（比如百度）
     *
     * @param url 菜单网址（比如百度）
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取按钮图标
     *
     * @return icon - 按钮图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置按钮图标
     *
     * @param icon 按钮图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取菜单排序
     *
     * @return sort - 菜单排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置菜单排序
     *
     * @param sort 菜单排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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