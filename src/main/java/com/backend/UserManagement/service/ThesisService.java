package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Thesis;

import java.util.List;

public interface ThesisService {
    List<Thesis> getAllThesis();

    Thesis saveThesis(Thesis thesis);

    Thesis getThesisById(int idThesis);

    Thesis updateThesis(Thesis thesis, int idThesis);

    void deleteThesisById(int idThesis);

}
