package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.User;

import java.util.List;

public interface AdminService {
    List<User> getAllAdmin();

    User saveAdmin(User admin);

    User getAdminById(long id);

    User getAdminByMail(String mail);

    User updateAdmin(User admin, long id);

    void deleteAdminById(long id);
}
