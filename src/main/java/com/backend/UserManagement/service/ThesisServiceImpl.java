package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Thesis;
import com.backend.UserManagement.repository.ThesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ThesisServiceImpl implements ThesisService {

    @Autowired
    private ThesisRepository thesisRepository;


    @Override
    public List<Thesis> getAllThesis() {
        return (List<Thesis>) thesisRepository.findAll();
    }

    @Override
    public Thesis saveThesis(Thesis thesis) {
        return thesisRepository.save(thesis);
    }

    @Override
    public Thesis getThesisById(int idThesis) {
        return thesisRepository.findById(idThesis).get();
    }

    @Override
    public Thesis updateThesis(Thesis thesis, int idThesis) {
        Thesis existingThesis = thesisRepository.findById(idThesis).get();

        if (Objects.nonNull(thesis.getName()) && !"".equalsIgnoreCase(thesis.getName())) {
            existingThesis.setName(thesis.getName());
        }

        if (Objects.nonNull(thesis.getName()) && !"".equalsIgnoreCase(thesis.getName())) {
            existingThesis.setName(thesis.getName());
        }

        if (Objects.nonNull(thesis.getDescription()) && !"".equalsIgnoreCase(thesis.getDescription())) {
            existingThesis.setDescription(thesis.getDescription());
        }

        if (Objects.nonNull(thesis.getFieldOfStudy()) && !"".equals(thesis.getFieldOfStudy())) {
            existingThesis.setFieldOfStudy(thesis.getFieldOfStudy());
        }

        if (Objects.nonNull(thesis.getCampus()) && !"".equalsIgnoreCase(thesis.getCampus())) {
            existingThesis.setCampus(thesis.getCampus());
        }

        return thesisRepository.save(existingThesis);
    }

    @Override
    public void deleteThesisById(int idThesis) {
        thesisRepository.deleteById(idThesis);
    }
}
