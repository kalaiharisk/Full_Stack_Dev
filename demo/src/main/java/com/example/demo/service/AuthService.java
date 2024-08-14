package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.response.LoginResponse;
import com.example.demo.dto.response.UserResponse;

public interface AuthService {
    String register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
    String createAdmin();
    List<UserResponse> getAllUser();
    UserResponse getUserById(Long id);
    UserResponse updateUser(Long id, UserResponse userResponse);
    void deleteUser(Long id);
}
