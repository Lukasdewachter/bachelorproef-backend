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
@RequestMapping(path="/thesis") // This means URL's start with (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class ThesisController {
    @Autowired
    private ThesisRepository thesisRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewThesis (@RequestParam String name) {
        Thesis t = new Thesis();
        t.setName(name);
        thesisRepository.save(t);
        return "Saved";
    }

    //TODO - Delete
    @PostMapping(path="/delete")
    public @ResponseBody String deleteThesis (@RequestParam int id) {
        thesisRepository.deleteById(id);
        return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Thesis> getAllThesis() {
        // This returns a JSON or XML with the users
        return thesisRepository.findAll();
    }
}