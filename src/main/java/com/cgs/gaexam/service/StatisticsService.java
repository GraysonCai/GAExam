package com.cgs.gaexam.service;


import com.cgs.gaexam.model.dto.CurriculumDetail;
import com.cgs.gaexam.model.dto.CurriculumMastery;

import java.util.List;

public interface StatisticsService {

    /**
     * 统计某位用户所有课程总做题情况
     *
     * @param userId
     * @return
     */
    CurriculumMastery statisticsCurriculumMasteryByUserId(long userId);

    /**
     * 统计某位用户课程掌握情况详情列表
     *
     * @param userId
     * @return
     */
    List<CurriculumDetail> statisticsCurriculumDetailByUserId(long userId);
}
