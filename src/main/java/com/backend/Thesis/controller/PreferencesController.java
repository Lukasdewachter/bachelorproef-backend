package com.backend.Thesis.controller;
import com.backend.Thesis.entity.Preferences;
import com.backend.Thesis.service.PreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/preferences") // This means URL's start with (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class PreferencesController {
    @Autowired
    private PreferencesService preferencesService;

    // Add operation
    @PreAuthorize("hasAnyRole('Student', 'Admin')")
    @PostMapping(path="/add")
    public Preferences savePreferences(@RequestBody Preferences preferences) {
        return preferencesService.savePreferences(preferences);
    }

    // Delete operation
    @PreAuthorize("hasAnyRole('Admin')")
    @DeleteMapping(path="/delete")
    public @ResponseBody String deletePreferences (@RequestParam long id) {
        preferencesService.deletePreferencesById(id);
        return "Deleted";
    }

    // Get all operation
    @PreAuthorize("hasAnyRole('Professor', 'Admin')")
    @GetMapping(path="/all")
    public List<Preferences> fetchPreferencesList() {
        return preferencesService.getAllPreferences();
    }

    // Update operation
    @PreAuthorize("hasAnyRole('Student', 'Admin')")
    @PutMapping("/update/{id}")
    public Preferences updatePreferences(@RequestBody Preferences preferences, @PathVariable("id") long id) {
        return preferencesService.updatePreferences(preferences, id);
    }
}