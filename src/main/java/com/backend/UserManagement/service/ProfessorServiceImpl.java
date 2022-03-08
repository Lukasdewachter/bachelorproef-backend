package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Professor;
import com.backend.UserManagement.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;


    @Override
    public List<Professor> getAllProfessor() {
        return (List<Professor>) professorRepository.findAll();
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor getProfessorById(int idProfessor) {
        return professorRepository.findById(idProfessor).get();
    }

    @Override
    public Professor updateProfessor(Professor professor, int idProfessor) {
        Professor existingProfessor = professorRepository.findById(idProfessor).get();

        if (Objects.nonNull(professor.getName()) && !"".equalsIgnoreCase(professor.getName())) {
            existingProfessor.setName(professor.getName());
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

        return professorRepository.save(existingProfessor);
    }

    @Override
    public void deleteProfessorById(int idProfessor) {
        professorRepository.deleteById(idProfessor);
    }
}
