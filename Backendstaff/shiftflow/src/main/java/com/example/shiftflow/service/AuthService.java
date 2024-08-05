package com.example.shiftflow.service;

import com.example.shiftflow.enums.Role;
import com.example.shiftflow.model.User;
import com.example.shiftflow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User addAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        return userRepo.save(user);
    }

    public String login(User user) {
        User foundUser = userRepo.findByUsername(user.getUsername());
        if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.builder()
        .username(user.getUsername())
        .password(user.getPassword())
        .authorities(user.getRole().getAuthorities())
        .build();
    }
}
