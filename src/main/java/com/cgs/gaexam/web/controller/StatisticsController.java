package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.dto.CurriculumMastery;
import com.cgs.gaexam.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cgs on 2018/04/06.
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/curriculum/mastery/{userId}")
    public Result curriculumMastery(@PathVariable Long userId) {
        CurriculumMastery curriculumMastery = statisticsService.statisticsCurriculumMasteryByUserId(userId);
        curriculumMastery.setCurriculumDetailList(statisticsService.statisticsCurriculumDetailByUserId(userId));
        return ResultGenerator.genSuccessResult(curriculumMastery);
    }
}
