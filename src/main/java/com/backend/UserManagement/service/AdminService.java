package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Admin;
import com.backend.UserManagement.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmin();

    Admin saveAdmin(Admin admin);

    Admin getAdminById(int idAdmin);

    Admin getAdminByMail(String mail);

    Admin updateAdmin(Admin admin, int idAdmin);

    void deleteAdminById(int idAdmin);

}
