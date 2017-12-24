package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.UserRoleMapper;
import com.cgs.gaexam.model.UserRole;
import com.cgs.gaexam.service.UserRoleService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/24.
 */
@Service
@Transactional
public class UserRoleServiceImpl extends AbstractService<UserRole> implements UserRoleService {
    @Resource
    private UserRoleMapper gaUserRoleMapper;

}
