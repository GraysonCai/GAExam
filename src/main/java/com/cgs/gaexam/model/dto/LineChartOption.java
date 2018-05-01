package com.cgs.gaexam.model.dto;

import java.util.Arrays;

public class LineChartOption {
    private String title;
    private String subtitle;
    private String seriesName;
    private String[] xAxisData;
    private float[] seriesData;
    private int max;

    public LineChartOption(String[] xAxisData, float[] seriesData, int max) {
        this.xAxisData = xAxisData;
        this.seriesData = seriesData;
        this.max = max;
    }

    public LineChartOption() {
    }

    @Override
    public String toString() {
        return "LineChartOption{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", xAxisData=" + Arrays.toString(xAxisData) +
                ", seriesData=" + Arrays.toString(seriesData) +
                ", max=" + max +
                '}';
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String[] getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(String[] xAxisData) {
        this.xAxisData = xAxisData;
    }

    public float[] getSeriesData() {
        return seriesData;
    }

    public void setSeriesData(float[] seriesData) {
        this.seriesData = seriesData;
    }
}
