package com.backend.Thesis.repository;

import com.backend.Thesis.entity.Preferences;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called StudentRepository
// CRUD refers Create, Read, Update, Delete

public interface PreferencesRepository extends CrudRepository<Preferences, Long> {

}