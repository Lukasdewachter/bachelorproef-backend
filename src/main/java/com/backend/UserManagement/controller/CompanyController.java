package com.backend.UserManagement.controller;

import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/company") // This means URL's start with professor (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class CompanyController {
    @Autowired
    private UserService userService;

    // Add operation
    @PreAuthorize("hasAnyRole('Admin')")
    @PostMapping(path="/add")
    public User saveCompany(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Delete operation
    @PreAuthorize("hasAnyRole('Admin')")
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteCompany (@RequestParam long id) {
        userService.deleteUserById(id);
        return "Deleted";
    }

    // Get all operation
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping(path="/all")
    public List<User> fetchCompanyList() {
        return userService.getAllCompany();
    }

    // Update operation
    @PreAuthorize("hasAnyRole('Company', 'Admin')")
    @PutMapping("/update/{id}")
    public User updateCompany(@RequestBody User user, @PathVariable("id") int id) {
        return userService.updateUser(user, id);
    }
}