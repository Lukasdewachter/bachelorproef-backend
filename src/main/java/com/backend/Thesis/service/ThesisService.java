package com.backend.Thesis.service;

import com.backend.Thesis.entity.Thesis;

import java.util.List;

public interface ThesisService {
    List<Thesis> getAllThesis();

    List<Thesis> getAllApprovedThesis();


    Thesis saveThesis(Thesis thesis);

    Thesis getThesisById(long id);

    Thesis updateThesis(Thesis thesis, long id);

    void deleteThesisById(long id);
    List<Thesis> getBookmarkByUser(Long userId);

    Thesis addStudentToThesis(long thesisId, long studentId);
}
