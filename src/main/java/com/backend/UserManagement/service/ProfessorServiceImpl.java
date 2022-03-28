package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.repository.RolesRepository;
import com.backend.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository roleService;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public List<User> getAllProfessor() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Professor"));
    }

    @Override
    public User saveProfessor(User professor) {
        return userRepository.save(professor);
    }

    @Override
    public User getProfessorById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateProfessor(User professor, long id) {
        User existingProfessor = userRepository.findById(id).get();

        if (Objects.nonNull(professor.getFirstName()) && !"".equalsIgnoreCase(professor.getFirstName())) {
            existingProfessor.setFirstName(professor.getFirstName());
        }

        if (Objects.nonNull(professor.getSurname()) && !"".equalsIgnoreCase(professor.getSurname())) {
            existingProfessor.setSurname(professor.getSurname());
        }

        if (Objects.nonNull(professor.getMail()) && !"".equalsIgnoreCase(professor.getMail())) {
            existingProfessor.setMail(professor.getMail());
        }

        if (Objects.nonNull(professor.getTel()) && !"".equals(professor.getTel())) {
            existingProfessor.setTel(professor.getTel());
        }

        if (Objects.nonNull(professor.getAddress()) && !"".equalsIgnoreCase(professor.getAddress())) {
            existingProfessor.setAddress(professor.getAddress());
        }

        if (Objects.nonNull(professor.getFieldOfStudy()) && !"".equalsIgnoreCase(professor.getFieldOfStudy())) {
            existingProfessor.setFieldOfStudy(professor.getFieldOfStudy());
        }

        if (Objects.nonNull(professor.getCampus()) && !"".equalsIgnoreCase(professor.getCampus())) {
            existingProfessor.setCampus(professor.getCampus());
        }

        if (Objects.nonNull(professor.getCoordinator()) && !"".equals(professor.getCoordinator())) {
            existingProfessor.setCoordinator(professor.getCoordinator());
        }

        return userRepository.save(existingProfessor);
    }

    @Override
    public void deleteProfessorById(long id) {
        userRepository.deleteById(id);
    }
}
