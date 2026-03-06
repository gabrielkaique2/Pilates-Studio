package com.StudioPilates.StudioPilates.Services;

import java.util.Optional;

import com.StudioPilates.StudioPilates.repository.RegisterNewUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.StudioPilates.StudioPilates.model.UserProfile;
import com.StudioPilates.StudioPilates.enums.Role;
import com.StudioPilates.StudioPilates.controller.RegisterUserController;

@Service
public class RegistrationService {

    @Autowired
    private RegisterNewUserRepository registerRepo;

    @Autowired
    private PasswordEncoder pwdEncoder;

    public boolean registerUser(UserProfile user) {
        Optional<UserProfile> userContainer = registerRepo.findByEmail(user.getEmail());
        if(userContainer.isEmpty()) {
            user.setRole(Role.ROLE_USER);
            user.setPassword(pwdEncoder.encode(user.getPassword()));
            registerRepo.save(user);
            return true;
        }
        return false;
    }

    public boolean registerAdmin(UserProfile admin) {
        Optional<UserProfile> userContainer = registerRepo.findByEmail(admin.getEmail());
        if(userContainer.isEmpty()) {
            admin.setRole(Role.ROLE_ADMIN);
            admin.setPassword(pwdEncoder.encode(admin.getPassword()));
            registerRepo.save(admin);
            return true;
        }
        return false;
    }

}