package com.cgs.gaexam.service;

import com.cgs.gaexam.model.User;
import com.cgs.gaexam.model.dto.LoginUser;

public interface AuthService {
    User register(User userToAdd);

    LoginUser login(String username, String password);

    String refresh(String oldToken);
}
