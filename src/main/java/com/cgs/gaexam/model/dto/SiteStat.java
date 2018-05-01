package com.cgs.gaexam.model.dto;

public class SiteStat {

    private long questionNumber;
    private long paperNumber;
    private long examNumber;
    private long studentNumber;
    private long teacherNumber;

    @Override
    public String toString() {
        return "SiteStat{" +
                "questionNumber=" + questionNumber +
                ", paperNumber=" + paperNumber +
                ", examNumber=" + examNumber +
                ", studentNumber=" + studentNumber +
                ", teacherNumber=" + teacherNumber +
                '}';
    }

    public long getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(long questionNumber) {
        this.questionNumber = questionNumber;
    }

    public long getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(long paperNumber) {
        this.paperNumber = paperNumber;
    }

    public long getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(long examNumber) {
        this.examNumber = examNumber;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public long getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(long teacherNumber) {
        this.teacherNumber = teacherNumber;
    }
}
