package com.backend.Thesis.service;

import com.backend.Thesis.entity.Thesis;

import java.util.List;

public interface ThesisService {
    List<Thesis> getAllThesis();

    Thesis saveThesis(Thesis thesis);

    Thesis getThesisById(long id);

    Thesis updateThesis(Thesis thesis, long id);

    void deleteThesisById(long id);

}
