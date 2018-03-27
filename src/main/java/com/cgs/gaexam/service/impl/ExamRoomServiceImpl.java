package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.ExamRoomMapper;
import com.cgs.gaexam.model.ExamRoom;
import com.cgs.gaexam.service.ExamRoomService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/03/20.
 */
@Service
@Transactional
public class ExamRoomServiceImpl extends AbstractService<ExamRoom> implements ExamRoomService {
    @Autowired
    private ExamRoomMapper gaExamRoomMapper;


}
