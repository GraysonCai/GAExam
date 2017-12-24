package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.Tester;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest extends Tester {

    @Autowired
    private UserService userService;

    @Test
    public void findByUsernameWithRoles() {
        String username = "admin";
        User user = userService.findByUsernameWithRoles(username);
        System.out.println(user);
    }

}