package com.backend.Thesis.repository;

import com.backend.Thesis.entity.Thesis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called StudentRepository
// CRUD refers Create, Read, Update, Delete

public interface ThesisRepository extends CrudRepository<Thesis, Long> {
    List<Thesis> findAllByBookmarksId(long userId);
}