package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.RuleMapper;
import com.cgs.gaexam.model.Rule;
import com.cgs.gaexam.service.RuleService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/01/28.
 */
@Service
@Transactional
public class RuleServiceImpl extends AbstractService<Rule> implements RuleService {
    @Autowired
    private RuleMapper gaRuleMapper;

}
