package com.cgs.gaexam.model.dto;

import com.cgs.gaexam.model.UserExamRecord;

import java.util.Date;

public class UserExamRecordInfo extends UserExamRecord {

    private String statusName;
    private String resultName;
    private int totalScore;
    private String className;
    private String name;
    private String examName;
    private String courseName;
    private Date startDate;
    private Date endDate;

    @Override
    public String toString() {
        return "UserExamRecordInfo{" +
                "statusName='" + statusName + '\'' +
                ", resultName='" + resultName + '\'' +
                ", totalScore=" + totalScore +
                ", className='" + className + '\'' +
                ", name='" + name + '\'' +
                ", examName='" + examName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                "} " + super.toString();
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
