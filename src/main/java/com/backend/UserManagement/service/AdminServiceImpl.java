package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Admin;
import com.backend.UserManagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public List<Admin> getAllAdmin() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        Admin newAdmin = new Admin(admin);
        newAdmin.setPassword(bcryptEncoder.encode(admin.getPassword()));
        return adminRepository.save(newAdmin);
    }

    @Override
    public Admin getAdminById(int idAdmin) {
        return adminRepository.findById(idAdmin).get();
    }

    @Override
    public Admin getAdminByMail(String mail) {
        return adminRepository.findByMail(mail);
    }

    @Override
    public Admin updateAdmin(Admin admin, int idAdmin) {
        Admin existingAdmin = adminRepository.findById(idAdmin).get();

        if (Objects.nonNull(admin.getName()) && !"".equalsIgnoreCase(admin.getName())) {
            existingAdmin.setName(admin.getName());
        }

        if (Objects.nonNull(admin.getSurname()) && !"".equalsIgnoreCase(admin.getSurname())) {
            existingAdmin.setSurname(admin.getSurname());
        }

        if (Objects.nonNull(admin.getMail()) && !"".equalsIgnoreCase(admin.getMail())) {
            existingAdmin.setMail(admin.getMail());
        }

        return adminRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdminById(int idAdmin) {
        adminRepository.deleteById(idAdmin);
    }
}
