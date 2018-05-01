package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.StatisticsMapper;
import com.cgs.gaexam.model.dto.CurriculumDetail;
import com.cgs.gaexam.model.dto.CurriculumMastery;
import com.cgs.gaexam.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;

    @Override
    public CurriculumMastery statisticsCurriculumMasteryByUserId(long userId) {
        return statisticsMapper.statisticsCurriculumMasteryByUserId(userId);
    }

    @Override
    public List<CurriculumDetail> statisticsCurriculumDetailByUserId(long userId) {
        List<CurriculumDetail> curriculumDetails = statisticsMapper.statisticsCurriculumDetailByUserId(userId);
        for (CurriculumDetail curriculumDetail : curriculumDetails) {
            float rate = (float) curriculumDetail.getCourseCorrectQuestionNumber() / (float) curriculumDetail.getCourseDoneQuestionNumber();
            curriculumDetail.setCorrectRate((float) (Math.round(rate * 100)) / 100);
        }
        return curriculumDetails;
    }
}
