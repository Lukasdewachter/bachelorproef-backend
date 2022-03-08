package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> getAllProfessor();

    Professor saveProfessor(Professor professor);

    Professor getProfessorById(int idProfessor);

    Professor updateProfessor(Professor professor, int idProfessor);

    void deleteProfessorById(int idProfessor);

}
