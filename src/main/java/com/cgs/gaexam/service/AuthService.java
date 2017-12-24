package com.cgs.gaexam.service;

import com.cgs.gaexam.model.User;

public interface AuthService {
    User register(User userToAdd);

    String login(String username, String password);

    String refresh(String oldToken);
}
