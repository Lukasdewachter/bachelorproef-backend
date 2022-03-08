package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Company;
import com.backend.UserManagement.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public List<Company> getAllCompany() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(int idCompany) {
        return companyRepository.findById(idCompany).get();
    }

    @Override
    public Company updateCompany(Company company, int idCompany) {
        Company existingCompany = companyRepository.findById(idCompany).get();

        if (Objects.nonNull(company.getCompanyName()) && !"".equalsIgnoreCase(company.getCompanyName())) {
            existingCompany.setCompanyName(company.getCompanyName());
        }

        if (Objects.nonNull(company.getContactName()) && !"".equalsIgnoreCase(company.getContactName())) {
            existingCompany.setContactName(company.getContactName());
        }

        if (Objects.nonNull(company.getMail()) && !"".equalsIgnoreCase(company.getMail())) {
            existingCompany.setMail(company.getMail());
        }

        if (Objects.nonNull(company.getTel()) && !"".equals(company.getTel())) {
            existingCompany.setTel(company.getTel());
        }

        if (Objects.nonNull(company.getAddress()) && !"".equalsIgnoreCase(company.getAddress())) {
            existingCompany.setAddress(company.getAddress());
        }

        return companyRepository.save(existingCompany);
    }

    @Override
    public void deleteCompanyById(int idCompany) {
        companyRepository.deleteById(idCompany);
    }
}
