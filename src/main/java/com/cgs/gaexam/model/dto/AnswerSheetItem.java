package com.cgs.gaexam.model.dto;

public class AnswerSheetItem {
    private long questionType;
    private long questionId;
    private String answer;
    private float score;

    @Override
    public String toString() {
        return "AnswerSheetItem{" +
                "questionType=" + questionType +
                ", questionId=" + questionId +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                '}';
    }

    public AnswerSheetItem() {

    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public AnswerSheetItem(long questionType, long questionId, String answer) {
        this.questionType = questionType;
        this.questionId = questionId;
        this.answer = answer;
    }

    public long getQuestionType() {
        return questionType;
    }

    public void setQuestionType(long questionType) {
        this.questionType = questionType;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
