package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.ExamSignIn;
import com.cgs.gaexam.service.ExamSignInService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/04/26.
 */
@RestController
@RequestMapping("/exam/sign/in")
public class ExamSignInController {
    @Autowired
    private ExamSignInService examSignInService;

    @PostMapping
    public Result add(@RequestBody ExamSignIn examSignIn) {
        examSignInService.save(examSignIn);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        examSignInService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ExamSignIn examSignIn) {
        examSignInService.update(examSignIn);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        ExamSignIn examSignIn = examSignInService.findById(id);
        return ResultGenerator.genSuccessResult(examSignIn);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ExamSignIn> list = examSignInService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/count/exam/{examId}/user/{userId}")
    public Result countSignIn(@PathVariable Long examId, @PathVariable Long userId) {
        int count = examSignInService.countSignIn(examId, userId);
        return ResultGenerator.genSuccessResult(count);
    }


}
