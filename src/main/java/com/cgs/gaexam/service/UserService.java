package com.cgs.gaexam.service;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/24.
 */
public interface UserService extends Service<User> {

    List<String> getRolesByUserId(Long userId);

    User findByUsernameWithRoles(String username);
}
