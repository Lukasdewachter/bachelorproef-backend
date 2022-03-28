package com.backend.UserManagement.service;

import java.util.List;
import java.util.Objects;

import com.backend.UserManagement.entity.Roles;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.repository.RolesRepository;
import com.backend.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository roleService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public List<User> getAllStudents() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Student"));
    }

    @Override
    public User saveStudent(User student) {
        User newCompany = new User(student);
        //newCompany.setPassword(bcryptEncoder.encode(newCompany.getPassword()));
        Roles role = roleService.findByName("Company");
        newCompany.setRole(role);
        return userRepository.save(newCompany);
    }

    @Override
    public User getStudentById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateStudent(User student, long id) {
        User existingStudent = userRepository.findById(id).get();

        if (Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())) {
            existingStudent.setFirstName(student.getFirstName());
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

        if (Objects.nonNull(student.getCampus()) && !"".equalsIgnoreCase(student.getCampus())) {
            existingStudent.setCampus(student.getCampus());
        }

        return userRepository.save(existingStudent);
    }

    @Override
    public void deleteStudentById(long id) {
        userRepository.deleteById(id);
    }
}
