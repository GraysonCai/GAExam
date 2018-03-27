package com.cgs.gaexam.core.ga1.ga;

import java.sql.Date;

/**
 * ����Bean
 *
 * @author lixiaolin
 * @createDate 2016-06-22 20:17
 */
public class QuestionBean {
    /**
     * ��Ŀid
     */
    private long id;
    /**
     * ��Ŀ���� 1-��ѡ  2-��� 3-����
     */
    private int type;
    /**
     * �Ѷ�ϵ�� 0.3-1֮��
     */
    private double difficulty;
    /**
     * ��Ӧ֪ʶ��id
     */
    private long pointId;
    /**
     * ���
     */
    private String stem;
    /**
     * ѡ��A
     */
    private String choice1;
    /**
     * ѡ��B
     */
    private String choice2;
    /**
     * ѡ��C
     */
    private String choice3;
    /**
     * ѡ��D
     */
    private String choice4;
    /**
     * ��
     */
    private String answer;
    /**
     * ������id
     */
    private long userId;
    /**
     * ���ⴴ��ʱ�䣬Ĭ��Ϊ��ǰʱ���
     */
    private Date createTime;

    // ����Ϊ�����ֶΣ�Ϊ�˷������չʾ
    /**
     * ����������
     */
    private String userName;
    /**
     * ֪ʶ������
     *
     * @return
     */
    private String knowledgeName;

    // �����ֶΣ�����ʹ���Ŵ��㷨���
    /**
     * �����������HR����ʱָ��
     */
    private double score;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public long getPointId() {
        return pointId;
    }

    public void setPointId(long pointId) {
        this.pointId = pointId;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime1() {
        return createTime.toString();
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * ��дequals����
     */
    public boolean equals(Object obj) {
        return this.id == ((QuestionBean) obj).id;
    }

    /**
     * ��дHashCode����
     */
    public int hashCode() {
        return (int) (this.id + this.userId);
    }

    @Override
    public String toString() {
        return "QuestionBean{" +
                "id=" + id +
                ", type=" + type +
                ", difficulty=" + difficulty +
                ", pointId=" + pointId +
                ", stem='" + stem + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", choice4='" + choice4 + '\'' +
                ", answer='" + answer + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", userName='" + userName + '\'' +
                ", knowledgeName='" + knowledgeName + '\'' +
                ", score=" + score +
                '}';
    }
}
