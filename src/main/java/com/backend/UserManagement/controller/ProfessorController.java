package com.backend.UserManagement.controller;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/professor") // This means URL's start with professor (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    // Add operation
    @PostMapping(path="/add")
    public User saveProfessor(@RequestBody User professor) {
        return professorService.saveProfessor(professor);
    }

    // Delete operation
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteProfessor (@RequestParam int idProfessor) {
        professorService.deleteProfessorById(idProfessor);
        return "Deleted";
    }

    // Get all operation
    @GetMapping(path="/all")
    public List<User> fetchProfessorList() {
        return professorService.getAllProfessor();
    }

    // Update operation
    @PutMapping("/update/{id}")
    public User updateProfessor(@RequestBody User professor, @PathVariable("id") long id) {
        return professorService.updateProfessor(professor, id);
    }
}