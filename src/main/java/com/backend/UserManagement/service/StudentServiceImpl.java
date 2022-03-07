package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Student;
import com.backend.UserManagement.repository.StudentRepository;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int idStudent) {
        return studentRepository.findById(idStudent).get();
    }

    @Override
    public Student updateStudent(Student student, int idStudent) {
        Student existingStudent = studentRepository.findById(idStudent).get();

        if (Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())) {
            existingStudent.setName(student.getName());
        }

        if (Objects.nonNull(student.getSurname()) && !"".equalsIgnoreCase(student.getSurname())) {
            existingStudent.setSurname(student.getSurname());
        }

        if (Objects.nonNull(student.getMail()) && !"".equalsIgnoreCase(student.getMail())) {
            existingStudent.setMail(student.getMail());
        }

        if (Objects.nonNull(student.getTel()) && !"".equals(student.getTel())) {
            existingStudent.setTel(student.getTel());
        }

        if (Objects.nonNull(student.getAddress()) && !"".equalsIgnoreCase(student.getAddress())) {
            existingStudent.setAddress(student.getAddress());
        }

        if (Objects.nonNull(student.getFieldOfStudy()) && !"".equalsIgnoreCase(student.getFieldOfStudy())) {
            existingStudent.setFieldOfStudy(student.getFieldOfStudy());
        }

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudentById(int idStudent) {
        studentRepository.deleteById(idStudent);
    }
}
