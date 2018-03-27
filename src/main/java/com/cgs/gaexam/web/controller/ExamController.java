package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.Exam;
import com.cgs.gaexam.model.dto.ExamInfo;
import com.cgs.gaexam.service.ExamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/03/20.
 */
@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping
    public Result add(@RequestBody Exam exam) {
        exam.setStatus(ProjectConstant.EXAM_UNPUBLISH_CODE);
        examService.save(exam);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/publish")
    public Result saveAndPublish(@RequestBody Exam exam) {
        examService.saveAndPublish(exam);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/publish/{examId}")
    public Result publishById(@PathVariable Long examId) {
        examService.publishById(examId);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update/publish")
    public Result updateAndPublish(@RequestBody Exam exam) {
        examService.updateAndPublish(exam);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        //需要连同删除ga_user_exam_record表里相关的数据
        examService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Exam exam) {
        examService.update(exam);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        ExamInfo exam = examService.getExamInfoById(id);
        return ResultGenerator.genSuccessResult(exam);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ExamInfo> list = examService.findAllExamInfo();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
