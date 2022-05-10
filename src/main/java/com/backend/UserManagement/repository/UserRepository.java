package com.backend.UserManagement.repository;

import com.backend.UserManagement.entity.Roles;
import com.backend.UserManagement.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called StudentRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Long> {
    User findByMail(String mail);
    List<User> findByRole(Roles role);

    List<User> findAllByBookmarksId(long thesisId);

}
