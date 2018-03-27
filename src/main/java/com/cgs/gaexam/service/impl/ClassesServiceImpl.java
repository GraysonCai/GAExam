package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.ClassesMapper;
import com.cgs.gaexam.model.Classes;
import com.cgs.gaexam.service.ClassesService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/01/05.
 */
@Service
@Transactional
public class ClassesServiceImpl extends AbstractService<Classes> implements ClassesService {
    @Autowired
    private ClassesMapper gaClassMapper;

}
