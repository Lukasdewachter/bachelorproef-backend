package com.backend.UserManagement.controller;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/professor") // This means URL's start with professor (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class ProfessorController {
    @Autowired
    private UserService userService;

    // Add operation
    @PostMapping(path="/add")
    public @ResponseBody String saveProfessor(@RequestBody User professor) {
        return userService.saveUser(professor, "Professor");
    }

    // Delete operation
    @PreAuthorize("hasAnyRole('Admin')")
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteProfessor (@RequestParam int idProfessor) {
        userService.deleteUserById(idProfessor);
        return "Deleted";
    }

    // Get all operation
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping(path="/all")
    public List<User> fetchProfessorList() {
        return userService.getAllProfessor();
    }

    // Get is coordinator
    @PreAuthorize("hasAnyRole('Admin', 'Professor')")
    @PutMapping(path="/iscoordinator")
    public Boolean isProfessorCoordinator(@RequestBody ObjectNode json) {
        Long userId = json.get("userId").asLong();
        return userService.isCoordinator(userId);
    }

    // Update operation
    @PreAuthorize("hasAnyRole('Professor', 'Admin')")
    @PutMapping("/update/{id}")
    public User updateProfessor(@RequestBody User professor, @PathVariable("id") long id) {
        return userService.updateUser(professor, id);
    }
}