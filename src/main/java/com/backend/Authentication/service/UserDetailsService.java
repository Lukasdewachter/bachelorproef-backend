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
    public CustomUser loadUserByUsername(String usernameOrID) throws UsernameNotFoundException {
        User user;
        if (usernameOrID.contains("@")){
            user = userService.getUserByMail(usernameOrID);
        } else {
            Long id = Long.parseLong(usernameOrID);
            user = userService.getUserById(id);
        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username or ID: " + usernameOrID);
        }
        return new CustomUser(user.getMail(), user.getPassword(), getAuthority(user), user.getId(), user.getRole().getName());
    }


    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
        return authorities;
    }
}