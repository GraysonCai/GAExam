package com.cgs.gaexam.service;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.core.Service;
import com.cgs.gaexam.model.dto.UserSettings;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/24.
 */
public interface UserService extends Service<User> {

    /**
     * 通过用户名查找用户，附带权限列表
     *
     * @param username
     * @return
     */
    User findByUsernameWithRoles(String username);

    UserSettings getSelfInfo(Long userId);

    int updateUserById(User user);

    int resetPassword(User user);

}
