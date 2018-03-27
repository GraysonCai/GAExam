package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.Paper;
import com.cgs.gaexam.model.Question;
import com.cgs.gaexam.model.dto.QuestionInfo;
import com.cgs.gaexam.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/01/25.
 */
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Result add(@RequestBody Question question) {
        questionService.save(question);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        questionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Question question) {
        questionService.update(question);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        QuestionInfo questionInfo = questionService.getQuestionInfoById(id);
        return ResultGenerator.genSuccessResult(questionInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<QuestionInfo> list = questionService.findAllQuestionInfo();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("ids")
    public Result listByIds(@RequestBody Paper paper) {
        String questionIds = paper.getQuestionIds();
        Long ruleId = paper.getRuleId();
        List<QuestionInfo> list = questionService.findQuestionInfoByIds(questionIds, ruleId);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/ids/test")
    public Result listTestQuestionsByIds(@RequestBody Paper paper) {
        String questionIds = paper.getQuestionIds();
        Long ruleId = paper.getRuleId();
        List<QuestionInfo> list = questionService.findTestQuestionInfoByIds(questionIds, ruleId);
        return ResultGenerator.genSuccessResult(list);
    }

}
