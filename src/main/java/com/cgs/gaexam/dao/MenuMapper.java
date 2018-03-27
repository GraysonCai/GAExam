package com.cgs.gaexam.dao;

import com.cgs.gaexam.core.Mapper;
import com.cgs.gaexam.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends Mapper<Menu> {
    List<Menu> findByRoleId(@Param("roleId") long roleId);

    List<Menu> findByRoleIds(@Param("roleIds") List<Long> roleIds);
}