package com.cgs.gaexam.model.dto;

public class QuestionScore {
    private long questionId;
    private float score;

    @Override
    public String toString() {
        return "QuestionScore{" +
                "questionId=" + questionId +
                ", score=" + score +
                '}';
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
