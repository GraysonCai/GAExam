package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.Student;
import com.cgs.gaexam.model.dto.StudentInfo;
import com.cgs.gaexam.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CodeGenerator on 2018/01/05.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping
    public Result add(@RequestBody StudentInfo studentInfo) {
        studentService.addUserStudent(studentInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{userId}")
    public Result delete(@PathVariable Long userId) {
        studentService.deleteByUserId(userId);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result updateStudent(@RequestBody StudentInfo student) {
        studentService.updateUserStudent(student);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{userId}")
    public Result detailByUserId(@PathVariable Long userId) {
        StudentInfo student = studentService.findByUserId(userId);
        return ResultGenerator.genSuccessResult(student);
    }

    @GetMapping
    public Result listAllStudent(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StudentInfo> list = studentService.findAllStudent();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


}
