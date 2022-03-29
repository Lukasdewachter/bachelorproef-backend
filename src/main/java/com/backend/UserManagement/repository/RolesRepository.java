package com.backend.UserManagement.repository;

import com.backend.UserManagement.entity.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Long> {
    Roles findByName(String name);
}