package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.QuestionType;
import com.cgs.gaexam.service.QuestionTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/01/16.
 */
@RestController
@RequestMapping("/question/type")
public class QuestionTypeController {
    @Autowired
    private QuestionTypeService questionTypeService;

    @PostMapping
    public Result add(@RequestBody QuestionType questionType) {
        questionTypeService.save(questionType);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        questionTypeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody QuestionType questionType) {
        questionTypeService.update(questionType);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        QuestionType questionType = questionTypeService.findById(id);
        return ResultGenerator.genSuccessResult(questionType);
    }

    @GetMapping
    public Result pager(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<QuestionType> list = questionTypeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list")
    public Result list() {
        List<QuestionType> list = questionTypeService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }
}
