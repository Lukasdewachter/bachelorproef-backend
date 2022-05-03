package com.backend.Authentication.service;

import java.util.HashSet;
import java.util.Set;

import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUser loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userService.getUserByMail(mail);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + mail);
        }
        return new CustomUser(user.getMail(), user.getPassword(), getAuthority(user), user.getId(), user.getRole().getName());
    }


    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
        return authorities;
    }
}