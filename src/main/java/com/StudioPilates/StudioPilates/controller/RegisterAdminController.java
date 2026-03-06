package com.StudioPilates.StudioPilates.controller;

import com.StudioPilates.StudioPilates.Services.RegistrationService;
import com.StudioPilates.StudioPilates.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterAdminController {

    @Autowired
    RegistrationService registerService;

    @PostMapping("/register-admin")
    ResponseEntity<String> register(@RequestBody UserProfile admin){
        if( registerService.registerAdmin(admin)) {
            return ResponseEntity.ok("Admin created sucessfully!");
        }
        return ResponseEntity.badRequest().body("Admin already exists!");
    }
}
