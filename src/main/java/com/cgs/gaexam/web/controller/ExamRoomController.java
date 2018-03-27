package com.cgs.gaexam.web.controller;

import com.cgs.gaexam.core.Result;
import com.cgs.gaexam.core.ResultGenerator;
import com.cgs.gaexam.model.ExamRoom;
import com.cgs.gaexam.service.ExamRoomService;
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
@RequestMapping("/exam/room")
public class ExamRoomController {
    @Autowired
    private ExamRoomService examRoomService;

    @PostMapping
    public Result add(@RequestBody ExamRoom examRoom) {
        examRoomService.save(examRoom);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        examRoomService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody ExamRoom examRoom) {
        examRoomService.update(examRoom);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id) {
        ExamRoom examRoom = examRoomService.findById(id);
        return ResultGenerator.genSuccessResult(examRoom);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ExamRoom> list = examRoomService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/list")
    public Result list() {
        List<ExamRoom> list = examRoomService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }
}
