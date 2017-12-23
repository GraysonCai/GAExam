package com.cgs.gaexam.service;

import com.cgs.gaexam.model.User;
import com.conpany.project.Tester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserServiceTest extends Tester {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        User user = new User("cgs", "123456", "蔡小钢", 1, new Date());
        userService.save(user);
        System.out.println(userService.findBy("username", "cgs"));
    }
}