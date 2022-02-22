package com.authenticatie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequestMapping(path="/professor") // This means URL's start with professor (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewProfessor (@RequestParam String name) {
        Professor n = new Professor();
        n.setName(name);
        professorRepository.save(n);
        return "Saved";
    }

    //TODO - Delete
    @PostMapping(path="/delete")
    public @ResponseBody String deleteProfessor (@RequestParam int id) {
        professorRepository.deleteById(id);
        return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Professor> getAllProfessors() {
        // This returns a JSON or XML with the users
        return professorRepository.findAll();
    }
}