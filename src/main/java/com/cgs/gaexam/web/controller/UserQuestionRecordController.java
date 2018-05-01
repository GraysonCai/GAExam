package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.UserQuestionRecord;
import com.cgs.gaexam.model.dto.UserQuestionRecordInfo;
import com.cgs.gaexam.service.UserQuestionRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/03/28.
 */
@RestController
@RequestMapping("/user/question/record")
public class UserQuestionRecordController {
    @Autowired
    private UserQuestionRecordService userQuestionRecordService;

    @PostMapping
    public Result add(@RequestBody UserQuestionRecord userQuestionRecord) {
        userQuestionRecordService.save(userQuestionRecord);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userQuestionRecordService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody UserQuestionRecord userQuestionRecord) {
        userQuestionRecordService.update(userQuestionRecord);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        UserQuestionRecord userQuestionRecord = userQuestionRecordService.findById(id);
        return ResultGenerator.genSuccessResult(userQuestionRecord);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserQuestionRecord> list = userQuestionRecordService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/{userId}/exam/{examId}")
    public Result list(@PathVariable("userId") long userId, @PathVariable("examId") long examId) {

        List<UserQuestionRecord> list = userQuestionRecordService.findQuestionRecordByUserAndExam(userId, examId);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/{userId}/wrong")
    public Result listWrongQuestion(@PathVariable("userId") long userId, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserQuestionRecordInfo> list = userQuestionRecordService.findUserWrongQuestionRecord(userId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list/{userId}")
    public Result listAllQuestionRecord(@PathVariable("userId") long userId, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserQuestionRecordInfo> list = userQuestionRecordService.findUserAllQuestionRecord(userId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
