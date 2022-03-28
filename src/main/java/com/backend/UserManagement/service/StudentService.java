package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.User;

import java.util.List;

public interface StudentService {
    List<User> getAllStudents();

    User saveStudent(User student);

    User getStudentById(long id);

    User updateStudent(User student, long id);

    void deleteStudentById(long id);

}
