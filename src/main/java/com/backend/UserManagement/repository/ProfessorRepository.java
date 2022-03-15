package com.backend.UserManagement.repository;

import com.backend.UserManagement.entity.Professor;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called StudentRepository
// CRUD refers Create, Read, Update, Delete

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

}