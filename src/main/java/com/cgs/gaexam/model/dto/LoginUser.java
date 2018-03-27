package com.cgs.gaexam.model.dto;

public class LoginUser {
    private String name;
    private Long userId;
    private String username;
    private Long loginDate;
    private String token;

    public LoginUser(String name, Long userId, String username, Long loginDate, String token) {
        this.name = name;
        this.userId = userId;
        this.username = username;
        this.loginDate = loginDate;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Long loginDate) {
        this.loginDate = loginDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", loginDate=" + loginDate +
                ", token='" + token + '\'' +
                '}';
    }
}
