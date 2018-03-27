package com.cgs.gaexam.model.dto;

import com.cgs.gaexam.model.Question;

public class QuestionInfo extends Question {
    private String typeName;
    private String courseName;
    private String knowledgeIdsName;
    private String createUser;
    //组卷使用
    private double score;

    @Override
    public String toString() {
        return "QuestionInfo{" +
                "typeName='" + typeName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", knowledgeIdsName='" + knowledgeIdsName + '\'' +
                ", createUser='" + createUser + '\'' +
                ", score=" + score +
                "} " + super.toString();
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
