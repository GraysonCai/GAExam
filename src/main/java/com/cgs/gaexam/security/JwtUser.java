package com.cgs.gaexam.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {

    /**
     * 用户标识
     */
    private final Long id;

    /**
     * 用户名
     */
    private final String username;

    /**
     * 密码
     */
    private final String password;

    /**
     * 真实姓名
     */
    private final String name;

    /**
     * 性别，0表示女，1表示男
     */
    private final Byte sex;

    /**
     * 年龄
     */
    private final Byte age;

    /**
     * 联系电话
     */
    private final Long phone;

    /**
     * 电子邮箱
     */
    private final String email;

    /**
     * 上次修改密码的日期
     */
    private final Date lastPasswordResetDate;

    /**
     * 创建时间
     */
    private final Date createDate;

    /**
     * 创建人
     */
    private final Long createBy;

    /**
     * 是否停用，0表示停用，1表示激活
     */
    private final Byte enabled;

    private final Collection<? extends GrantedAuthority> grantedAuthorities;

    public JwtUser(Long id, String username, String password, String name, Byte sex, Byte age, Long phone, String email, Date lastPasswordResetDate, Date createDate, Long createBy, Byte enabled, Collection<? extends GrantedAuthority> grantedAuthorities) {
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
        this.grantedAuthorities = grantedAuthorities;
    }

    public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    @Override
    public String getUsername() {
        return username;
    }

    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    // 账户是否未过期
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否未过期
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否激活
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        if (enabled == 1) {
            return true;
        } else if (enabled == 0) {
            return false;
        }
        return false;
    }

}
