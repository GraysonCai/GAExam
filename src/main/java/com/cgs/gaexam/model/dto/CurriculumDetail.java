package com.cgs.gaexam.model.dto;

public class CurriculumDetail {

    private long courseId;
    private String courseName;
    private int courseDoneQuestionNumber;       // 该课程已做的题目
    private int courseCorrectQuestionNumber;    // 该课程作对的题目
    private int courseTotalQuestionNumber;      // 该课程总的题目数
    private float correctRate;                    // 该课程正确率=该课程作对的题目/该课程已做的题目

    @Override
    public String toString() {
        return "CurriculumDetail{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDoneQuestionNumber=" + courseDoneQuestionNumber +
                ", courseCorrectQuestionNumber=" + courseCorrectQuestionNumber +
                ", courseTotalQuestionNumber=" + courseTotalQuestionNumber +
                ", correctRate=" + correctRate +
                '}';
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseDoneQuestionNumber() {
        return courseDoneQuestionNumber;
    }

    public void setCourseDoneQuestionNumber(int courseDoneQuestionNumber) {
        this.courseDoneQuestionNumber = courseDoneQuestionNumber;
    }

    public int getCourseCorrectQuestionNumber() {
        return courseCorrectQuestionNumber;
    }

    public void setCourseCorrectQuestionNumber(int courseCorrectQuestionNumber) {
        this.courseCorrectQuestionNumber = courseCorrectQuestionNumber;
    }

    public int getCourseTotalQuestionNumber() {
        return courseTotalQuestionNumber;
    }

    public void setCourseTotalQuestionNumber(int courseTotalQuestionNumber) {
        this.courseTotalQuestionNumber = courseTotalQuestionNumber;
    }

    public float getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(float correctRate) {
        this.correctRate = correctRate;
    }
}
