package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.dto.TeacherInfo;
import com.cgs.gaexam.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CodeGenerator on 2018/01/05.
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public Result add(@RequestBody TeacherInfo teacherInfo) {
        teacherService.addUserTeacher(teacherInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{userId}")
    public Result delete(@PathVariable Long userId) {
        teacherService.deleteByUserId(userId);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result updateStudent(@RequestBody TeacherInfo teacherInfo) {
        teacherService.updateUserTeacher(teacherInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{userId}")
    public Result detailByUserId(@PathVariable Long userId) {
        TeacherInfo teacherInfo = teacherService.findByUserId(userId);
        return ResultGenerator.genSuccessResult(teacherInfo);
    }

    @GetMapping
    public Result listTeacherByPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TeacherInfo> list = teacherService.findAllTeacher();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list")
    public Result listAllTeacher() {
        List<TeacherInfo> list = teacherService.findAllTeacher();
        return ResultGenerator.genSuccessResult(list);
    }
}
