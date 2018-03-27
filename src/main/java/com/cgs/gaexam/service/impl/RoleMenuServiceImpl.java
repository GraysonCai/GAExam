package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.RoleMenuMapper;
import com.cgs.gaexam.model.RoleMenu;
import com.cgs.gaexam.service.RoleMenuService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/26.
 */
@Service
@Transactional
public class RoleMenuServiceImpl extends AbstractService<RoleMenu> implements RoleMenuService {
    @Autowired
    private RoleMenuMapper gaRoleMenuMapper;

}
