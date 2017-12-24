package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.UserMapper;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.service.UserService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/24.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper gaUserMapper;

    @Override
    public List<String> getRolesByUserId(Long userId) {
        return gaUserMapper.getRolesByUserId(userId);
    }

    @Override
    public User findByUsernameWithRoles(String username) {
        return gaUserMapper.findByUsernameWithRoles(username);
    }
}
