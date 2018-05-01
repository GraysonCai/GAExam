package com.cgs.gaexam.model.dto;

import java.util.List;

public class PieChartOption {
    private String className;
    private String examName;
    private List<Data<Integer>> data;

    @Override
    public String toString() {
        return "PieChartOption{" +
                "className='" + className + '\'' +
                ", examName='" + examName + '\'' +
                ", data=" + data +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public List<Data<Integer>> getData() {
        return data;
    }

    public void setData(List<Data<Integer>> data) {
        this.data = data;
    }
}
