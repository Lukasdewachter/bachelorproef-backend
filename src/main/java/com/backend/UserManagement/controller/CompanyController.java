package com.backend.UserManagement.controller;

import com.backend.UserManagement.entity.Company;
import com.backend.UserManagement.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequestMapping(path="/company") // This means URL's start with professor (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewCompany (
            @RequestParam String companyName,
            @RequestParam String contactName,
            @RequestParam String mail,
            @RequestParam Integer tel,
            @RequestParam String address
    ) {
        Company c = new Company();
        c.setCompanyName(companyName);
        c.setAddress(address);
        c.setContactName(contactName);
        c.setTel(tel);
        c.setMail(mail);
        companyRepository.save(c);
        return "Saved";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteCompany (@RequestParam int idCompany) {
        companyRepository.deleteById(idCompany);
        return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Company> getAllCompanies() {
        // This returns a JSON or XML with the users
        return companyRepository.findAll();
    }
}