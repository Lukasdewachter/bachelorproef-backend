package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(int idStudent);

    Student updateStudent(Student student, int idStudent);

    void deleteStudentById(int idStudent);

}
