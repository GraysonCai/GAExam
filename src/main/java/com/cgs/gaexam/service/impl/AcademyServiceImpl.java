package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.AcademyMapper;
import com.cgs.gaexam.model.Academy;
import com.cgs.gaexam.service.AcademyService;
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
public class AcademyServiceImpl extends AbstractService<Academy> implements AcademyService {
    @Autowired
    private AcademyMapper gaAcademyMapper;

}
