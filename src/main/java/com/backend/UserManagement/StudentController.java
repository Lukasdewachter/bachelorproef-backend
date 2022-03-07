package com.backend.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequestMapping(path="/student") // This means URL's start with /student (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewStudent (
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam int tel,
            @RequestParam String address,
            @RequestParam String fieldOfStudy,
            @RequestParam String mail
            ) {
        Student n = new Student();
        n.setName(name);
        n.setSurname(surname);
        n.setTel(tel);
        n.setAddress(address);
        n.setFieldOfStudy(fieldOfStudy);
        n.setMail(mail);
        studentRepository.save(n);
        return "Saved";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteStudent (@RequestParam int idStudent) {
        studentRepository.deleteById(idStudent);
        return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllStudents() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }
}