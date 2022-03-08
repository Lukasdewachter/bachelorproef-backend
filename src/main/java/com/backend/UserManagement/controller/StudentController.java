package com.backend.UserManagement.controller;
import com.backend.UserManagement.entity.Student;
import com.backend.UserManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/student") // This means URL's start with /student (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {
    @Autowired
    private StudentService studentService;

    // Add operation
    @PostMapping("/add")
    public Student saveStudent( @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Delete operation
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteStudent (@RequestParam int idStudent) {
        studentService.deleteStudentById(idStudent);
        return "Deleted";
    }

    // Get all operation
    @GetMapping(path="/all")
    public List<Student> fetchStudentList() {
        return studentService.getAllStudents();
    }

    // Update operation
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int idStudent) {
        return studentService.updateStudent(student, idStudent);
    }

}