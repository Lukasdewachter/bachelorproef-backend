package com.backend.Authentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()

@PreAuthorize("hasRole('Admin')")
public class HelloWorldController {
    @RequestMapping({ "/hello" })
    public String hello() {
        return "Hello World";
    }
}
