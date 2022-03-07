package com.backend.UserManagement.repository;

import com.backend.UserManagement.entity.Thesis;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called StudentRepository
// CRUD refers Create, Read, Update, Delete

public interface ThesisRepository extends CrudRepository<Thesis, Integer> {

}