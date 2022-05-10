package com.backend.Thesis.service;

import com.backend.Thesis.entity.Thesis;
import com.backend.Thesis.repository.ThesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Thesis> getAllApprovedThesis() {
        List<Thesis> allThesis = (List<Thesis>) thesisRepository.findAll();
        List<Thesis> approvedThesis = new ArrayList<>();
        for(int i=0; i<allThesis.size(); i++){
            if(allThesis.get(i).getApproved()){
                approvedThesis.add(allThesis.get(i));
            }
        }
        return approvedThesis;
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

        if (Objects.nonNull(thesis.getShortDescription()) && !"".equalsIgnoreCase(thesis.getShortDescription())) {
            existingThesis.setShortDescription(thesis.getShortDescription());
        }

        if (Objects.nonNull(thesis.getLongDescription()) && !"".equalsIgnoreCase(thesis.getLongDescription())) {
            existingThesis.setLongDescription(thesis.getLongDescription());
        }

        if (Objects.nonNull(thesis.getFieldOfStudy()) && !"".equals(thesis.getFieldOfStudy())) {
            existingThesis.setFieldOfStudy(thesis.getFieldOfStudy());
        }

        if (Objects.nonNull(thesis.getCampus()) && !"".equalsIgnoreCase(thesis.getCampus())) {
            existingThesis.setCampus(thesis.getCampus());
        }

        if (Objects.nonNull(thesis.getPromotor()) && !"".equalsIgnoreCase(thesis.getPromotor())) {
            existingThesis.setPromotor(thesis.getPromotor());
        }

        if (Objects.nonNull(thesis.getnumberOfPers()) && !"".equals(thesis.getnumberOfPers())) {
            existingThesis.setnumberOfPers(thesis.getnumberOfPers());
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

    @Override
    public List<Thesis> getBookmarkByUser(Long userId){
        return thesisRepository.findAllByBookmarksId(userId);
    }
}
