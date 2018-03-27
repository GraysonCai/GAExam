package com.cgs.gaexam.service;

import com.cgs.gaexam.model.Role;
import com.cgs.gaexam.core.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/24.
 */
public interface RoleService extends Service<Role> {

    List<Role> findRolesByUserId(@Param("userId") Long userId);
}
