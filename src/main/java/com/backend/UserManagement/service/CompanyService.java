package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.User;

import java.util.List;

public interface CompanyService {
    List<User> getAllCompany();

    User saveCompany(User company);

    User getCompanyById(long id);

    User updateCompany(User company, long id);

    void deleteCompanyById(long id);

}
