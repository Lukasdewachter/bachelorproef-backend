package com.backend.Thesis.service;

import com.backend.Thesis.entity.Thesis;
import com.backend.Thesis.repository.ThesisRepository;
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
        thesis.setApproved(false);
        return thesisRepository.save(thesis);
    }

    @Override
    public Thesis getThesisById(long id) {
        return thesisRepository.findById(id).get();
    }

    @Override
    public Thesis updateThesis(Thesis thesis, long id) {
        Thesis existingThesis = thesisRepository.findById(id).get();

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

        if (Objects.nonNull(thesis.getApproved()) && !"".equals(thesis.getApproved())) {
            existingThesis.setApproved(thesis.getApproved());
        }

        return thesisRepository.save(existingThesis);
    }

    @Override
    public void deleteThesisById(long id) {
        thesisRepository.deleteById(id);
    }
}
