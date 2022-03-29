package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<User> getAllAdmin();

    List<User> getAllCompany();

    List<User> getAllProfessor();

    List<User> getAllStudent();

    User saveUser(User user);

    User getUserById(long id);

    User getUserByMail(String mail);

    User updateUser(User user, long id);

    void deleteUserById(long id);
}