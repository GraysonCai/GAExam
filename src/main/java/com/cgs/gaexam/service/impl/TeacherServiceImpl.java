package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.core.AbstractService;
import com.cgs.gaexam.core.ServiceException;
import com.cgs.gaexam.dao.TeacherMapper;
import com.cgs.gaexam.dao.UserMapper;
import com.cgs.gaexam.model.Teacher;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.model.dto.TeacherInfo;
import com.cgs.gaexam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/01/05.
 */
@Service
@Transactional
public class TeacherServiceImpl extends AbstractService<Teacher> implements TeacherService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TeacherMapper gaTeacherMapper;

    @Override
    public List<TeacherInfo> findAllTeacher() {
        return gaTeacherMapper.findAll();
    }

    @Override
    public void deleteByUserId(Long userId) {
        int result = gaTeacherMapper.deleteByUserId(userId);
        if (result <= 0)
            throw new ServiceException("删除教师失败！");
        result = userMapper.deleteByIds(String.valueOf(userId));
        if (result <= 0)
            throw new ServiceException("删除用户失败！");
    }

    @Override
    public int addUserTeacher(TeacherInfo teacherInfo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePwd = encoder.encode(teacherInfo.getPassword());
        User user = new User(teacherInfo.getUsername(), encodePwd, teacherInfo.getName(),
                teacherInfo.getSex(), teacherInfo.getAge(), teacherInfo.getPhone(), teacherInfo.getEmail(), new Date(), 1L, teacherInfo.getEnabled());
        userMapper.insert(user);
        user = userMapper.findByUsername(user.getUsername());
        Teacher teacher = new Teacher(user.getId(), teacherInfo.getAcademyId(), teacherInfo.getTitle(),
                new Date(), 1L);
        return gaTeacherMapper.insert(teacher);
    }

    @Override
    public TeacherInfo findByUserId(Long userId) {
        return gaTeacherMapper.findByUserId(userId);
    }

    @Override
    public void updateUserTeacher(TeacherInfo teacherInfo) {
        User user = new User(teacherInfo.getUserId(), teacherInfo.getName(),
                teacherInfo.getSex(), teacherInfo.getAge(), teacherInfo.getPhone(), teacherInfo.getEmail(), teacherInfo.getEnabled());
        int result = userMapper.updateUserById(user);
        if (result < 0) {
            throw new ServiceException("更新教师信息失败!");
        }
        Teacher teacher = new Teacher(teacherInfo.getTeacherId(), teacherInfo.getAcademyId(), teacherInfo.getTitle());
        result = gaTeacherMapper.updateTeacherById(teacher);
        if (result < 0) {
            throw new ServiceException("更新用户信息失败!");
        }
    }
}
