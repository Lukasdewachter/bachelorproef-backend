package com.backend.UserManagement.controller;
import com.backend.UserManagement.Exception.ResourceNotFoundException;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalLong;

@RestController
@RequestMapping(path="/student") // This means URL's start with /student (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {
    @Autowired
    private UserService userService;

    // Add operation
    @PostMapping("/add")
    public @ResponseBody String saveStudent(@RequestBody User student) {
        return userService.saveUser(student, "Student");
    }

    // Delete operation
    @PreAuthorize("hasAnyRole('Admin')")
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteStudent (@RequestParam long id) {
        userService.deleteUserById(id);
        return "Deleted";
    }

    // Get all operation
    @PreAuthorize("hasAnyRole('Admin', 'Professor')")
    @GetMapping(path="/all")
    public List<User> fetchStudentList() {
        if (userService.getAllStudent() == null){
            throw new ResourceNotFoundException("Niet gevonden");
        }
        return userService.getAllStudent();
    }

    // Update operation
    @PreAuthorize("hasAnyRole('Student', 'Admin')")
    @PutMapping("/update/{id}")
    public User updateStudent(@RequestBody User student, @PathVariable("id") long id) {
        return userService.updateUser(student, id);
    }

}