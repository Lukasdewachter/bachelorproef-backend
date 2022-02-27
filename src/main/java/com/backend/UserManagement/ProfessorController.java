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
@RequestMapping(path="/professor") // This means URL's start with professor (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewProfessor (
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String mail,
            @RequestParam Integer tel,
            @RequestParam String adress,
            @RequestParam String fieldOfStudy,
            @RequestParam String campus,
            @RequestParam boolean coordinator
            ){
        Professor n = new Professor();
        n.setName(name);
        n.setSurname(surname);
        n.setMail(mail);
        n.setTel(tel);
        n.setAdress(adress);
        n.setFieldOfStudy(fieldOfStudy);
        n.setCampus(campus);
        n.setCoordinator(coordinator);

        professorRepository.save(n);
        return "Saved";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteProfessor (@RequestParam int idProfessor) {
        professorRepository.deleteById(idProfessor);
        return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Professor> getAllProfessors() {
        // This returns a JSON or XML with the users
        return professorRepository.findAll();
    }
}