package com.cgs.gaexam.model.dto;

import com.cgs.gaexam.model.Exam;

import java.util.List;

public class ExamInfo extends Exam {
    private String courseName;
    private String createUser;
    private String statusName;
    private String paperName;
    private int passScore;      //及格分数
    private String examRoomNos;  //考场编号
    private String examClassNames;  //考试班级
    private List<String> examRoomNoList;  //考场编号
    private List<String> examClassList;   //考试班级列表
    private int totalScore; //总分
    private int duration;   //考试时长（分钟）

    @Override
    public String toString() {
        return "ExamInfo{" +
                "courseName='" + courseName + '\'' +
                ", createUser='" + createUser + '\'' +
                ", statusName='" + statusName + '\'' +
                ", paperName='" + paperName + '\'' +
                ", passScore=" + passScore +
                ", examRoomNos='" + examRoomNos + '\'' +
                ", examClassNames='" + examClassNames + '\'' +
                ", examRoomNoList=" + examRoomNoList +
                ", examClassList=" + examClassList +
                ", totalScore=" + totalScore +
                ", duration=" + duration +
                "} " + super.toString();
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPassScore() {
        return passScore;
    }

    public void setPassScore(int passScore) {
        this.passScore = passScore;
    }

    public String getExamClassNames() {
        return examClassNames;
    }

    public void setExamClassNames(String examClassNames) {
        this.examClassNames = examClassNames;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getExamRoomNos() {
        return examRoomNos;
    }

    public void setExamRoomNos(String examRoomNos) {
        this.examRoomNos = examRoomNos;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<String> getExamRoomNoList() {
        return examRoomNoList;
    }

    public void setExamRoomNoList(List<String> examRoomNoList) {
        this.examRoomNoList = examRoomNoList;
    }

    public List<String> getExamClassList() {
        return examClassList;
    }

    public void setExamClassList(List<String> examClassList) {
        this.examClassList = examClassList;
    }
}
