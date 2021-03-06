package com.backend.UserManagement.service;

import com.backend.Thesis.entity.Thesis;
import com.backend.UserManagement.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<User> getAllAdmin();

    List<User> getAllCompany();

    List<User> getAllProfessor();

    List<User> getAllStudent();

    String saveUser(User user, String roleName);

    User getUserById(long id);

    User getUserByMail(String mail);

    User updateUser(User user, long id);

    void deleteUserById(long id);

    void toggleBookmark(long thesisId, long userId);

    Boolean isCoordinator(long userId);

    User addStudentToThesis(long thesisId, long studentId);
}