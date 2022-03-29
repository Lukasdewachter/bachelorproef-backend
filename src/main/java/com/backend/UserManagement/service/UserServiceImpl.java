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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository roleService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> getAllAdmin() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Admin"));
    }

    @Override
    public List<User> getAllCompany() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Company"));
    }

    @Override
    public List<User> getAllStudent() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Student"));
    }

    @Override
    public List<User> getAllProfessor() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Professor"));
    }

    @Override
    public User saveUser(User user) {
        User newUser = new User(user);
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        //Roles role = roleService.findByName("Admin");
        //newAdmin.setRole(role);
        return userRepository.save(newUser);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUserByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser = userRepository.findById(id).get();

        if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
            existingUser.setFirstName(user.getFirstName());
        }

        if (Objects.nonNull(user.getSurname()) && !"".equalsIgnoreCase(user.getSurname())) {
            existingUser.setSurname(user.getSurname());
        }

        if (Objects.nonNull(user.getMail()) && !"".equalsIgnoreCase(user.getMail())) {
            existingUser.setMail(user.getMail());
        }

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
