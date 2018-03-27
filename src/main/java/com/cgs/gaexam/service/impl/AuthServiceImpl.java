package com.cgs.gaexam.service.impl;

import com.cgs.gaexam.core.ProjectConstant;
import com.cgs.gaexam.core.ServiceException;
import com.cgs.gaexam.dao.RoleMapper;
import com.cgs.gaexam.dao.UserMapper;
import com.cgs.gaexam.dao.UserRoleMapper;
import com.cgs.gaexam.model.Role;
import com.cgs.gaexam.model.User;
import com.cgs.gaexam.model.UserRole;
import com.cgs.gaexam.model.dto.LoginUser;
import com.cgs.gaexam.security.JwtUser;
import com.cgs.gaexam.service.AuthService;
import com.cgs.gaexam.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 1.登录时要生成token，完成Spring Security认证，然后返回token给客户端
 * 2.注册时将用户密码用BCrypt加密，写入用户角色，由于是开放注册，所以写入角色系统控制，将其写成 ROLE_USER
 * 3.提供一个可以刷新token的接口 refresh 用于取得新的token
 */
@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UserMapper userMapper;
    private UserRoleMapper userRoleMapper;
    private RoleMapper roleMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            UserMapper userMapper,
            RoleMapper roleMapper,
            UserRoleMapper userRoleMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public User register(User userToAdd) {
        final String username = userToAdd.getUsername();
        if (userMapper.findByUsername(username) != null) {
            throw new ServiceException("该用户已存在！");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setEnabled(ProjectConstant.ENABLED);
        userToAdd.setAge((byte) 0);
        userToAdd.setSex((byte) 1);
        userToAdd.setCreateBy(1L);
        userToAdd.setPhone(0L);
        int r = userMapper.insert(userToAdd);
        if (r < 0) throw new ServiceException("注册用户失败");
        //获取学生角色信息
        Role role = new Role();
        role.setAuthority(ProjectConstant.STUDENT);
        role = roleMapper.selectOne(role);
        //获取用户信息
        User user = userMapper.findByUsername(username);
        //默认为注册用户设置学生的角色
        UserRole userRole = new UserRole();
        //注册默认角色为学生
        userRole.setRoleId(role.getId());
        userRole.setUserId(user.getId());
        userRoleMapper.insert(userRole);
        user.setRoles(asList(role.getAuthority()));
        return user;
    }

    private List<String> asList(String str) {
        if (str == null)
            return null;
        String[] list = str.split(",");
        return Arrays.asList(list);
    }

    @Override
    public LoginUser login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(upToken);
        } catch (AuthenticationException e) {
            throw new ServiceException("账号或密码错误！");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = tokenHead + jwtTokenUtil.generateToken(userDetails);
        User user = userMapper.findByUsername(username);
        LoginUser lg = new LoginUser(user.getName(), user.getId(), user.getUsername(), new Date().getTime(), token);
        return lg;
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}
