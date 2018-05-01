package com.cgs.gaexam.model.dto;

import com.cgs.gaexam.model.UserQuestionRecord;

import java.util.Date;

public class UserQuestionRecordInfo extends UserQuestionRecord {
    private String stem;    //题目名称
    private String examName;
    private String courseName;
    private String knowledgeIdsName;
    private Date answerDate;

    @Override
    public String toString() {
        return "UserQuestionRecordInfo{" +
                "stem='" + stem + '\'' +
                ", examName='" + examName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", knowledgeIdsName='" + knowledgeIdsName + '\'' +
                ", answerDate=" + answerDate +
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

    public String getKnowledgeIdsName() {
        return knowledgeIdsName;
    }

    public void setKnowledgeIdsName(String knowledgeIdsName) {
        this.knowledgeIdsName = knowledgeIdsName;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }
}
