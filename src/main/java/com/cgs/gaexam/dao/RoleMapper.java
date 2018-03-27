package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends Mapper<Role> {

    /**
     * 通过用户id查询权限列表
     *
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(@Param("userId") Long userId);
}