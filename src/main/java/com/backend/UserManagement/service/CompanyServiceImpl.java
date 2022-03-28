package com.backend.UserManagement.service;

import com.backend.UserManagement.entity.Roles;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.repository.RolesRepository;
import com.backend.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository roleService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public List<User> getAllCompany() {
        return (List<User>) userRepository.findByRole(roleService.findByName("Company"));
    }

    @Override
    public User saveCompany(User company) {
        User newCompany = new User(company);
        //newCompany.setPassword(bcryptEncoder.encode(newCompany.getPassword()));
        Roles role = roleService.findByName("Company");
        newCompany.setRole(role);
        return userRepository.save(newCompany);
    }

    @Override
    public User getCompanyById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User updateCompany(User company, long id) {
        User existingCompany = userRepository.findById(id).get();

        if (Objects.nonNull(company.getCompanyName()) && !"".equalsIgnoreCase(company.getCompanyName())) {
            existingCompany.setCompanyName(company.getCompanyName());
        }

        if (Objects.nonNull(company.getFirstName()) && !"".equalsIgnoreCase(company.getFirstName())) {
            existingCompany.setFirstName(company.getFirstName());
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

        return userRepository.save(existingCompany);
    }

    @Override
    public void deleteCompanyById(long id) {
        userRepository.deleteById(id);
    }
}
