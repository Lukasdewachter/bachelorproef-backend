package com.backend.UserManagement.controller;

import com.backend.Thesis.entity.Thesis;
import com.backend.Thesis.service.ThesisService;
import com.backend.UserManagement.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/bookmark") // This means URL's start with (after Application path)
@CrossOrigin(origins = "http://localhost:3000")
public class BookmarkController {
    @Autowired
    private UserService userService;

    @Autowired
    private ThesisService thesisService;

    @PreAuthorize("hasAnyRole('Admin', 'Student')")
    @PostMapping(path="/toggleBookmark")
    public @ResponseBody String toggleBookmark(@RequestBody ObjectNode json) {
        Long userId = json.get("userId").asLong();
        Long thesisId = json.get("thesisId").asLong();
        userService.toggleBookmark(thesisId, userId);
        return "Toggled";
    }

    @PreAuthorize("hasAnyRole('Admin', 'Student')")
    @PutMapping(path="/user")
    public List<Thesis> getBookmarkUser(@RequestBody ObjectNode json) {
        Long userId = json.get("userId").asLong();
        return thesisService.getBookmarkByUser(userId);
    }
}
