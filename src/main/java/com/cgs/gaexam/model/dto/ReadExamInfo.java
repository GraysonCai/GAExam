package com.cgs.gaexam.model.dto;

import java.util.List;

public class ReadExamInfo {

    private long examRecordId;
    private long examId;
    private long userId;
    private float passScore;
    private List<QuestionScore> markList;


    @Override
    public String toString() {
        return "ReadExamInfo{" +
                "examRecordId=" + examRecordId +
                ", examId=" + examId +
                ", userId=" + userId +
                ", passScore=" + passScore +
                ", markList=" + markList +
                '}';
    }

    public float getPassScore() {
        return passScore;
    }

    public void setPassScore(float passScore) {
        this.passScore = passScore;
    }

    public long getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(long examRecordId) {
        this.examRecordId = examRecordId;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<QuestionScore> getMarkList() {
        return markList;
    }

    public void setMarkList(List<QuestionScore> markList) {
        this.markList = markList;
    }
}
