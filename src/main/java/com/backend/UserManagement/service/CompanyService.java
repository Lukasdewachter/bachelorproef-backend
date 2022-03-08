package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();

    Company saveCompany(Company company);

    Company getCompanyById(int idCompany);

    Company updateCompany(Company company, int idCompany);

    void deleteCompanyById(int idCompany);

}
