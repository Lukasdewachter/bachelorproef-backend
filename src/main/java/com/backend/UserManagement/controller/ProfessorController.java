package com.backend.UserManagement.controller;
import com.backend.UserManagement.entity.Professor;
import com.backend.UserManagement.entity.Professor;
import com.backend.UserManagement.repository.ProfessorRepository;
import com.backend.UserManagement.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public Professor saveProfessor(@RequestBody Professor professor) {
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
    public List<Professor> fetchProfessorList() {
        return professorService.getAllProfessor();
    }

    // Update operation
    @PutMapping("/update/{id}")
    public Professor updateProfessor(@RequestBody Professor professor, @PathVariable("id") int idProfessor) {
        return professorService.updateProfessor(professor, idProfessor);
    }
}