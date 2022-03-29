package com.backend.UserManagement.controller;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/student") // This means URL's start with /student (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

@PreAuthorize("hasAnyRole('Admin', 'Student')")
public class StudentController {
    @Autowired
    private UserService userService;

    // Add operation
    @PostMapping("/add")
    public User saveStudent(@RequestBody User student) {
        return userService.saveUser(student);
    }

    // Delete operation
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteStudent (@RequestParam long id) {
        userService.deleteUserById(id);
        return "Deleted";
    }

    // Get all operation
    @GetMapping(path="/all")
    public List<User> fetchStudentList() {
        return userService.getAllStudent();
    }

    // Update operation
    @PreAuthorize("hasRole('Student')")
    @PutMapping("/update/{id}")
    public User updateStudent(@RequestBody User student, @PathVariable("id") long id) {
        return userService.updateUser(student, id);
    }

}