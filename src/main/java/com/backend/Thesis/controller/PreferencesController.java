package com.backend.Thesis.controller;
import com.backend.Thesis.entity.Preferences;
import com.backend.Thesis.service.PreferencesService;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

    // Get one operation
    @PreAuthorize("hasAnyRole('Student', 'Admin')")
    @PutMapping(path="/user")
    public Preferences getPreference(@RequestBody ObjectNode json) {
        Long userId = json.get("idStudent").asLong();
        return preferencesService.getPreferencesByIdStudent(userId);
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
    @PostMapping("/update/{id}")
    public Preferences updatePreferences(@RequestBody Preferences preferences, @PathVariable("id") long userId) {
        return preferencesService.updatePreferences(preferences, userId);
    }
}