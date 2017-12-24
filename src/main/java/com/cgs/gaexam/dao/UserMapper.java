package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper extends Mapper<User> {
    /**
     * 通过用户名查询用户
     *
     * @param username
     * @return
     */
    User findByUsername(@Param("username") String username);

    /**
     * 通过用户id查询权限列表
     *
     * @param userId
     * @return
     */
    List<String> getRolesByUserId(@Param("userId") Long userId);

    /**
     * 通过用户名查询用户，带上权限
     *
     * @param username
     * @return
     */
    User findByUsernameWithRoles(@Param("username") String username);
}