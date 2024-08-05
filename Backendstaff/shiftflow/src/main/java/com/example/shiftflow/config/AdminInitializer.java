package com.example.shiftflow.config;

import com.example.shiftflow.enums.Role;
import com.example.shiftflow.model.User;
import com.example.shiftflow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner createAdmin() {
        return args -> {
            if (userRepo.findByUsername("admin2004") == null) {
                User admin = new User();
                admin.setUsername("admin2004");
                admin.setPassword(passwordEncoder.encode("admin2004"));
                admin.setRole(Role.ADMIN);
                admin.setEmail("admin@example.com");
                userRepo.save(admin);
            }
        };
    }
}
