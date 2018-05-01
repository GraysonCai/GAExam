package com.cgs.gaexam.model.dto;

import com.cgs.gaexam.model.UserExamRecord;

import java.util.Date;

public class UserExamRecordInfo extends UserExamRecord {

    private String statusName;
    private String resultName;
    private float totalScore;   //获得总分(主观题、客观题)
    private float paperScore;   //试卷总分
    private float passScore;   //及格总分
    private String className;
    private String name;        //姓名
    private String examName;
    private String courseName;
    private String paperName;      //试卷名称
    private Date startDate;     //考试开始时间
    private Date endDate;       //考试结束时间
    private String teacher;     //任教老师
    private int duration;       //考试时长

    @Override
    public String toString() {
        return "UserExamRecordInfo{" +
                "statusName='" + statusName + '\'' +
                ", resultName='" + resultName + '\'' +
                ", totalScore=" + totalScore +
                ", paperScore=" + paperScore +
                ", passScore=" + passScore +
                ", className='" + className + '\'' +
                ", name='" + name + '\'' +
                ", examName='" + examName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", paperName='" + paperName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", teacher='" + teacher + '\'' +
                ", duration=" + duration +
                "} " + super.toString();
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getPassScore() {
        return passScore;
    }

    public void setPassScore(float passScore) {
        this.passScore = passScore;
    }

    public float getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(float paperScore) {
        this.paperScore = paperScore;
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

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
