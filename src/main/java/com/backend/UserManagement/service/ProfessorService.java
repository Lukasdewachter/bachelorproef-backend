package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.User;

import java.util.List;

public interface ProfessorService {
    List<User> getAllProfessor();

    User saveProfessor(User professor);

    User getProfessorById(long idProfessor);

    User updateProfessor(User professor, long idProfessor);

    void deleteProfessorById(long idProfessor);

}
