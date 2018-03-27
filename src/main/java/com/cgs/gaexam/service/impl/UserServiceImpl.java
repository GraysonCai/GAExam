package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.dao.StudentMapper;
import com.cgs.gaexam.dao.TeacherMapper;
import com.cgs.gaexam.dao.UserMapper;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.model.dto.UserSettings;
import com.cgs.gaexam.service.UserService;
import com.cgs.gaexam.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2017/12/24.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Autowired
    private UserMapper gaUserMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public User findByUsernameWithRoles(String username) {
        return gaUserMapper.findByUsernameWithRoles(username);
    }

    @Override
    public UserSettings getSelfInfo(Long userId) {
        UserSettings userSettings = new UserSettings();
        if (studentMapper.existStudent(userId)) {
            userSettings.setRole(ProjectConstant.STUDENT);
            userSettings.setStudentInfo(studentMapper.findByUserId(userId));
        } else if (teacherMapper.existTeacher(userId)) {
            userSettings.setRole(ProjectConstant.TEACHER);
            userSettings.setTeacherInfo(teacherMapper.findByUserId(userId));
        } else if (gaUserMapper.existUser(userId)) {
            userSettings.setRole(ProjectConstant.ADMIN);
            userSettings.setAdminInfo(gaUserMapper.selectByPrimaryKey(userId));
        }
        return userSettings;
    }

    @Override
    public int updateUserById(User user) {
        return gaUserMapper.updateUserById(user);
    }

    @Override
    public int resetPassword(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return gaUserMapper.updateUserById(user);
    }
}
