package com.example.shiftflow.controller;

import com.example.shiftflow.model.User;
import com.example.shiftflow.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AuthService authService;

    @PostMapping("/add")
    public User addAdmin(@RequestBody User user) {
        return authService.addAdmin(user);
    }
}
