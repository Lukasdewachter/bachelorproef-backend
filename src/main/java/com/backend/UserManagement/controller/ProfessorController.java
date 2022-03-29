package com.backend.UserManagement.controller;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/professor") // This means URL's start with professor (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

@PreAuthorize("hasAnyRole('Admin', 'Professor')")
public class ProfessorController {
    @Autowired
    private UserService userService;

    // Add operation
    @PostMapping(path="/add")
    public User saveProfessor(@RequestBody User professor) {
        return userService.saveUser(professor);
    }

    // Delete operation
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteProfessor (@RequestParam int idProfessor) {
        userService.deleteUserById(idProfessor);
        return "Deleted";
    }

    // Get all operation
    @GetMapping(path="/all")
    public List<User> fetchProfessorList() {
        return userService.getAllProfessor();
    }

    // Update operation
    @PutMapping("/update/{id}")
    public User updateProfessor(@RequestBody User professor, @PathVariable("id") long id) {
        return userService.updateUser(professor, id);
    }
}