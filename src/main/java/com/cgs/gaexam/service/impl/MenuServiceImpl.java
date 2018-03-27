package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.dao.MenuMapper;
import com.cgs.gaexam.model.Menu;
import com.cgs.gaexam.service.MenuService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/29.
 */
@Service
@Transactional
public class MenuServiceImpl extends AbstractService<Menu> implements MenuService {
    @Autowired
    private MenuMapper gaMenuMapper;

    @Override
    public List<Menu> findByRoleId(long roleId) {
        return gaMenuMapper.findByRoleId(roleId);
    }

    @Override
    public List<Menu> findByRoleIds(List<Long> roleIds) {
        return gaMenuMapper.findByRoleIds(roleIds);
    }
}
