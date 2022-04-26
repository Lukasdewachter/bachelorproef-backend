package com.backend.Thesis.controller;
import com.backend.Thesis.entity.Thesis;
import com.backend.Thesis.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/thesis") // This means URL's start with (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class ThesisController {
    @Autowired
    private ThesisService thesisService;

    // Add operation
    @PreAuthorize("hasAnyRole('Company', 'Admin')")
    @PostMapping(path="/add")
    public Thesis saveThesis(@RequestBody Thesis thesis) {
        return thesisService.saveThesis(thesis);
    }

    // Delete operation
    @PreAuthorize("hasAnyRole('Admin')")
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteThesis (@RequestParam long id) {
        thesisService.deleteThesisById(id);
        return "Deleted";
    }

    // Get all operation
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping(path="/all")
    public List<Thesis> fetchThesisList() {
        return thesisService.getAllThesis();
    }

    // Update operation
    @PreAuthorize("hasAnyRole('Company', 'Admin')")
    @PutMapping("/update/{id}")
    public Thesis updateThesis(@RequestBody Thesis thesis, @PathVariable("id") long id) {
        return thesisService.updateThesis(thesis, id);
    }
}