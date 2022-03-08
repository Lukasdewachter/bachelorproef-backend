package com.backend.UserManagement.controller;
import com.backend.UserManagement.entity.Thesis;
import com.backend.UserManagement.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/thesis") // This means URL's start with (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class ThesisController {
    @Autowired
    private ThesisService thesisService;

    // Add operation
    @PostMapping(path="/add")
    public Thesis saveThesis(@RequestBody Thesis thesis) {
        return thesisService.saveThesis(thesis);
    }

    // Delete operation
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteThesis (@RequestParam int idThesis) {
        thesisService.deleteThesisById(idThesis);
        return "Deleted";
    }

    // Get all operation
    @GetMapping(path="/all")
    public List<Thesis> fetchThesisList() {
        return thesisService.getAllThesis();
    }

    // Update operation
    @PutMapping("/update/{id}")
    public Thesis updateThesis(@RequestBody Thesis thesis, @PathVariable("id") int idThesis) {
        return thesisService.updateThesis(thesis, idThesis);
    }
}