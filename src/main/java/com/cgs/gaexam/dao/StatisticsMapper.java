package com.cgs.gaexam.dao;

import com.cgs.gaexam.model.dto.CurriculumDetail;
import com.cgs.gaexam.model.dto.CurriculumMastery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsMapper {

    /**
     * 统计某位用户所有课程总做题情况
     *
     * @param userId
     * @return
     */
    CurriculumMastery statisticsCurriculumMasteryByUserId(@Param("userId") long userId);

    /**
     * 统计某位用户课程掌握情况详情列表
     *
     * @param userId
     * @return
     */
    List<CurriculumDetail> statisticsCurriculumDetailByUserId(@Param("userId") long userId);

}
