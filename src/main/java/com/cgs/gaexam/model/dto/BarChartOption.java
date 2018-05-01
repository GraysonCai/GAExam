package com.cgs.gaexam.model.dto;

import java.util.Arrays;

public class BarChartOption {
    private String title;
    private String subtitle;
    private String seriesName;
    private String[] xAxisData;
    private float[] seriesData;

    public BarChartOption(String[] xAxisData, float[] seriesData) {
        this.xAxisData = xAxisData;
        this.seriesData = seriesData;
    }

    public BarChartOption() {
    }

    @Override
    public String toString() {
        return "BarChartOption{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", xAxisData=" + Arrays.toString(xAxisData) +
                ", seriesData=" + Arrays.toString(seriesData) +
                '}';
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
