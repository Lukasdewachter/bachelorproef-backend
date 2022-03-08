package com.backend.UserManagement.controller;

import com.backend.UserManagement.entity.Company;
import com.backend.UserManagement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/company") // This means URL's start with professor (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class CompanyController {
    @Autowired
    private CompanyService companyService;

    // Add operation
    @PostMapping(path="/add")
    public Company saveCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    // Delete operation
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteCompany (@RequestParam int idCompany) {
        companyService.deleteCompanyById(idCompany);
        return "Deleted";
    }

    // Get all operation
    @GetMapping(path="/all")
    public List<Company> fetchCompanyList() {
        return companyService.getAllCompany();
    }

    // Update operation
    @PutMapping("/update/{id}")
    public Company updateCompany(@RequestBody Company company, @PathVariable("id") int idCompany) {
        return companyService.updateCompany(company, idCompany);
    }
}