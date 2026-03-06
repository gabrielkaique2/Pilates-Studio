package com.StudioPilates.StudioPilates.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudioPilates.StudioPilates.model.UserProfile;

@RestController
public class RegisterUserController {

    @Autowired
    RegistrationService registerService;

    @PostMapping("/register")
    ResponseEntity<String> register(@RequestBody UserProfile user) {
        if(registerService.registerUser(user)) {
            return ResponseEntity.ok("User created successfully");
        }
        return ResponseEntity.badRequest().body("User created successfully");
    }
}
