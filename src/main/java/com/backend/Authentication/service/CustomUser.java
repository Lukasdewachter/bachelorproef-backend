package com.backend.Authentication.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    private long id;
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, long id, String role) {
        super(username, password, authorities);
        setId(id);
        setRole(role);
    }
}