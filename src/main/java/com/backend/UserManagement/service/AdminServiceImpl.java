package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Roles;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.repository.RolesRepository;
import com.backend.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository roleService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public List<User> getAllAdmin() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Company"));
    }

    @Override
    public User saveAdmin(User admin) {
        User newAdmin = new User(admin);
        newAdmin.setPassword(bcryptEncoder.encode(admin.getPassword()));
        Roles role = roleService.findByName("Admin");
        newAdmin.setRole(role);
        return userRepository.save(newAdmin);
    }

    @Override
    public User getAdminById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getAdminByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User updateAdmin(User admin, long id) {
        User existingAdmin = userRepository.findById(id).get();

        if (Objects.nonNull(admin.getFirstName()) && !"".equalsIgnoreCase(admin.getFirstName())) {
            existingAdmin.setFirstName(admin.getFirstName());
        }

        if (Objects.nonNull(admin.getSurname()) && !"".equalsIgnoreCase(admin.getSurname())) {
            existingAdmin.setSurname(admin.getSurname());
        }

        if (Objects.nonNull(admin.getMail()) && !"".equalsIgnoreCase(admin.getMail())) {
            existingAdmin.setMail(admin.getMail());
        }

        return userRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdminById(long id) {
        userRepository.deleteById(id);
    }
}
