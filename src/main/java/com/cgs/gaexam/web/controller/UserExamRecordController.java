package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.UserExamRecord;
import com.cgs.gaexam.model.dto.UserExamRecordInfo;
import com.cgs.gaexam.service.UserExamRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/03/21.
 */
@RestController
@RequestMapping("/exam/record")
public class UserExamRecordController {
    @Autowired
    private UserExamRecordService userExamRecordService;

    @PostMapping
    public Result add(@RequestBody UserExamRecord userExamRecord) {
        userExamRecordService.save(userExamRecord);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userExamRecordService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody UserExamRecord userExamRecord) {
        userExamRecordService.update(userExamRecord);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        UserExamRecord userExamRecord = userExamRecordService.findById(id);
        return ResultGenerator.genSuccessResult(userExamRecord);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") long examId, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserExamRecordInfo> list = userExamRecordService.findAllExamRecordInfo(examId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/user/{userId}")
    public Result list(@PathVariable("userId") long userId) {
        List<UserExamRecordInfo> list = userExamRecordService.findUserExamRecordInfo(userId);
        return ResultGenerator.genSuccessResult(list);
    }
}
