package com.cgs.gaexam.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "ga_user")
public class User {
    /**
     * 用户标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 性别，0表示女，1表示男
     */
    private Byte sex;

    /**
     * 年龄
     */
    private Byte age;

    /**
     * 联系电话
     */
    private Long phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 上次修改密码的日期
     */
    @Column(name = "last_password_reset_date")
    private Date lastPasswordResetDate;

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
     * 是否停用，0表示停用，1表示激活
     */
    private Byte enabled;

    /**
     * 自定义属性
     * 用户角色列表
     */
    @Transient
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    /**
     * 获取用户标识
     *
     * @return id - 用户标识
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户标识
     *
     * @param id 用户标识
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取真实姓名
     *
     * @return name - 真实姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置真实姓名
     *
     * @param name 真实姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别，0表示女，1表示男
     *
     * @return sex - 性别，0表示女，1表示男
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别，0表示女，1表示男
     *
     * @param sex 性别，0表示女，1表示男
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄，范围0-255
     *
     * @return age - 年龄，范围0-255
     */
    public Byte getAge() {
        return age;
    }

    /**
     * 设置年龄，范围0-255
     *
     * @param age 年龄，范围0-255
     */
    public void setAge(Byte age) {
        this.age = age;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取上次修改密码的日期
     *
     * @return last_password_reset_date - 上次修改密码的日期
     */
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    /**
     * 设置上次修改密码的日期
     *
     * @param lastPasswordResetDate 上次修改密码的日期
     */
    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
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

    /**
     * 获取是否停用，0表示停用，1表示激活
     *
     * @return enabled - 是否停用，0表示停用，1表示激活
     */
    public Byte getEnabled() {
        return enabled;
    }

    /**
     * 设置是否停用，0表示停用，1表示激活
     *
     * @param enabled 是否停用，0表示停用，1表示激活
     */
    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public User() {
    }

    public User(Long id, String username, String password, String name, Byte sex, Byte age, Long phone, String email, Date lastPasswordResetDate, Date createDate, Long createBy, Byte enabled, List<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.createDate = createDate;
        this.createBy = createBy;
        this.enabled = enabled;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", lastPasswordResetDate=" + lastPasswordResetDate +
                ", createDate=" + createDate +
                ", createBy=" + createBy +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}