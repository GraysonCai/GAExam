package com.cgs.gaexam.service;

import com.cgs.gaexam.model.Menu;
import com.cgs.gaexam.core.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/29.
 */
public interface MenuService extends Service<Menu> {

    List<Menu> findByRoleId(long roleId);

    List<Menu> findByRoleIds(List<Long> roleIds);
}
