package com.cgs.gaexam.service;

import com.cgs.gaexam.model.dto.SiteStat;

public interface SiteStatService {

    /**
     * 返回网站统计的各项数据
     *
     * @return
     */
    SiteStat siteStat();
}
