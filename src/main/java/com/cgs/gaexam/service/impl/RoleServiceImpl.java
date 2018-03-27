package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.RoleMapper;
import com.cgs.gaexam.model.Role;
import com.cgs.gaexam.service.RoleService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/24.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Autowired
    private RoleMapper gaRoleMapper;

    @Override
    public List<Role> findRolesByUserId(Long userId) {
        return gaRoleMapper.findRolesByUserId(userId);
    }
}
