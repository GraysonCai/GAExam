package com.cgs.gaexam.security;

import com.cgs.gaexam.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(user.getId(), user.getUsername(), user.getPassword(), user.getName(), user.getSex(), user.getAge(), user.getPhone(),
                user.getEmail(), user.getLastPasswordResetDate(), user.getCreateDate(), user.getCreateBy(), user.getEnabled(), mapToSimpleGrantedAuthority(user.getRoles()));
    }

    public static List<GrantedAuthority> mapToSimpleGrantedAuthority(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
