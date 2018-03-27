package com.cgs.gaexam.dao;

import com.cgs.gaexam.Tester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserMapperTest extends Tester {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void existsUser() {
        Long userId = 1L;
        boolean isExists = userMapper.existUser(userId);
        System.out.println(isExists);
    }
}