package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.dto.CurriculumMastery;
import com.cgs.gaexam.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sitestat")
@RestController
public class SiteStatController {

    @Autowired
    private SiteStatService siteStatService;


    @GetMapping
    public Result siteStat() {
        return ResultGenerator.genSuccessResult(siteStatService.siteStat());
    }

}
