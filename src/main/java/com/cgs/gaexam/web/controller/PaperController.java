package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.Paper;
import com.cgs.gaexam.model.dto.PaperInfo;
import com.cgs.gaexam.service.PaperService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/01/28.
 */
@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;

    @PostMapping
    public Result add(@RequestBody PaperInfo paper) {
        return ResultGenerator.genSuccessResult(paperService.createPaper(paper));
    }

    @PostMapping("/save")
    public Result save(@RequestBody Paper paper) {
        return ResultGenerator.genSuccessResult(paperService.updatePaperStatus(paper.getId(), ProjectConstant.PAPER_FINISHED));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        //TODO 删除规则
        paperService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Paper paper) {
        paperService.update(paper);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        PaperInfo paper = paperService.getPaperInfoById(id);
        return ResultGenerator.genSuccessResult(paper);
    }

    @GetMapping("/courseId/{courseId}")
    public Result getListByCourseId(@PathVariable Long courseId) {
        List<Paper> papers = paperService.findByCourseId(courseId);
        return ResultGenerator.genSuccessResult(papers);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PaperInfo> list = paperService.findAllPaperInfo();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list")
    public Result list() {
        List<PaperInfo> list = paperService.findAllPaperInfo();
        return ResultGenerator.genSuccessResult(list);
    }
}
