package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.UserMapper;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.service.UserService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2017/12/22.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
