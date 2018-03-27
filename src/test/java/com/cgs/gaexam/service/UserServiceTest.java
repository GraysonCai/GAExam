package com.cgs.gaexam.service;

import com.cgs.gaexam.Tester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest extends Tester {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        //User user = new User("cgs", "123456", "蔡小钢", 1, new Date());
        //userService.save(user);
        System.out.println(userService.findBy("username", "cgs"));
    }

    @Test
    public void getSelfInfo() {
        Long userId = 14L;
        System.out.println(userService.getSelfInfo(userId));
    }

    @Test
    public void testListToString() {
        List<Long> ids = new ArrayList<>();
        ids.add(12L);
        ids.add(1L);
        ids.add(3L);
        System.out.println(ids.toString());
    }
}