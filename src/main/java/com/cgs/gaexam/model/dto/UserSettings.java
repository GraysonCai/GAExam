package com.cgs.gaexam.model.dto;

import com.cgs.gaexam.model.User;

public class UserSettings {
    private User adminInfo;
    private TeacherInfo teacherInfo;
    private StudentInfo studentInfo;
    private String role;

    public User getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(User adminInfo) {
        this.adminInfo = adminInfo;
    }

    public TeacherInfo getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserSettings{" +
                "adminInfo=" + adminInfo +
                ", teacherInfo=" + teacherInfo +
                ", studentInfo=" + studentInfo +
                ", role='" + role + '\'' +
                '}';
    }
}
