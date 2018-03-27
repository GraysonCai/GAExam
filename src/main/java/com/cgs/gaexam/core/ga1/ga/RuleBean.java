package com.cgs.gaexam.core.ga1.ga;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * ������Bean
 *
 * @author: xlli
 * @CreateDate: 2016-4-28 ����05:02:05
 * @version: 1.0
 */
public class RuleBean {
    /**
     * ����id
     */
    private long id;
    /**
     * �����Ӧ�Ŀ���id
     */
    private long examId;
    /**
     * �Ծ��ܷ�
     */
    private int totalMark;
    /**
     * �Ծ������Ѷ�ϵ��
     */
    private double difficulty;
    /**
     * ��ѡ������
     */
    private int singleNum;
    /**
     * ��ѡ�ⵥ����ֵ
     */
    private double singleScore;
    /**
     * ���������
     */
    private int completeNum;
    /**
     * ����ⵥ����ֵ
     */
    private double completeScore;
    /**
     * ����������
     */
    private int subjectiveNum;
    /**
     * �����ⵥ����ֵ
     */
    private double subjectiveScore;
    /**
     * �Ծ������֪ʶ��id
     */
    private List<String> pointIds;
    /**
     * ���򴴽�ʱ��
     */
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getExamId() {
        return examId;
    }

    public void setExamId(long examId) {
        this.examId = examId;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public int getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(int singleNum) {
        this.singleNum = singleNum;
    }

    public double getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(double singleScore) {
        this.singleScore = singleScore;
    }

    public int getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(int completeNum) {
        this.completeNum = completeNum;
    }

    public double getCompleteScore() {
        return completeScore;
    }

    public void setCompleteScore(double completeScore) {
        this.completeScore = completeScore;
    }

    public int getSubjectiveNum() {
        return subjectiveNum;
    }

    public void setSubjectiveNum(int subjectiveNum) {
        this.subjectiveNum = subjectiveNum;
    }

    public double getSubjectiveScore() {
        return subjectiveScore;
    }

    public void setSubjectiveScore(double subjectiveScore) {
        this.subjectiveScore = subjectiveScore;
    }

    public List<String> getPointIds() {
        return pointIds;
    }

    public void setPointIds(String pointIds) {
        // �Ƿ��Ǳ�������������
        if (pointIds.endsWith("#")) {
            pointIds = pointIds.substring(0, pointIds.lastIndexOf("#"));
        }
        // ʹ��HashSetȥ��
        this.pointIds = new ArrayList<>(new HashSet<>(Arrays.asList(pointIds.split("#"))));
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
