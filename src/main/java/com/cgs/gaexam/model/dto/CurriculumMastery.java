package com.cgs.gaexam.model.dto;

import java.util.List;

public class CurriculumMastery {
    private long userId;
    private int totalDoneQuestionNumber;    //共做了多少题
    private int rightQuestionNumber;    //作对了多少题
    private List<CurriculumDetail> curriculumDetailList;    //课程掌握情况详情列表

    @Override
    public String toString() {
        return "CurriculumMastery{" +
                "userId=" + userId +
                ", totalDoneQuestionNumber=" + totalDoneQuestionNumber +
                ", rightQuestionNumber=" + rightQuestionNumber +
                ", curriculumDetailList=" + curriculumDetailList +
                '}';
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getTotalDoneQuestionNumber() {
        return totalDoneQuestionNumber;
    }

    public void setTotalDoneQuestionNumber(int totalDoneQuestionNumber) {
        this.totalDoneQuestionNumber = totalDoneQuestionNumber;
    }

    public int getRightQuestionNumber() {
        return rightQuestionNumber;
    }

    public void setRightQuestionNumber(int rightQuestionNumber) {
        this.rightQuestionNumber = rightQuestionNumber;
    }

    public List<CurriculumDetail> getCurriculumDetailList() {
        return curriculumDetailList;
    }

    public void setCurriculumDetailList(List<CurriculumDetail> curriculumDetailList) {
        this.curriculumDetailList = curriculumDetailList;
    }
}
