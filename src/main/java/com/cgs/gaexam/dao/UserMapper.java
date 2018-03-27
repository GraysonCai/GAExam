package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {
    /**
     * 通过用户名查询用户
     *
     * @param username
     * @return
     */
    User findByUsername(@Param("username") String username);



    /**
     * 通过用户名查询用户，带上权限
     *
     * @param username
     * @return
     */
    User findByUsernameWithRoles(@Param("username") String username);

    /**
     * 通过用户的id更新各个字段，排除为null的情况
     *
     * @param user
     * @return
     */
    int updateUserById(@Param("u") User user);

    /**
     * 判断是否存在用户
     *
     * @param userId
     * @return
     */
    boolean existUser(@Param("userId") Long userId);
}