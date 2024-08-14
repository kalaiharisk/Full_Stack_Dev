package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.RegisterRequest;
import com.example.demo.dto.response.LoginResponse;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.enums.Role;
import com.example.demo.model.Token;
import com.example.demo.model.User;
import com.example.demo.repository.JwtRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.AuthService;
import com.example.demo.utils.JwtToken;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final JwtRepo tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtToken jwtUtil;

    @Override
    public String register(RegisterRequest registerRequest) {
        Optional<User> userExist = userRepo.findByEmail(registerRequest.getEmail());
        if (userExist.isPresent()) {
            return "User already exists with email id " + registerRequest.getEmail();
        }
        var user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.User)
                .build();
        userRepo.save(user);
        return "User registered successfully.";
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        var user = userRepo.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("Invalid credentials"));
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", user.getRole().toString());
        var accessToken = jwtUtil.generateToken(extraClaims, user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        return LoginResponse.builder().accessToken(accessToken).build();
    }

    private void saveUserToken(User user, String accessToken) {
        var token = Token.builder().user(user).token(accessToken).expired(false).revoked(false).build();
        tokenRepository.save(token);
    }
    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllByUser_UidAndExpiredFalseAndRevokedFalse(user.getUid());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    @Override
    public String createAdmin() {
        Optional<User> userExist = userRepo.findByEmail("admin@gmail.com");
        if (userExist.isPresent()) {
            return "User already exists with email id - admin@gmail.com";
        }

        var user = User.builder()
                .name("Admin")
                .email("admin@gmail.com")
                .password(passwordEncoder.encode("Admin@123"))
                .role(Role.Admin)
                .build();
        userRepo.save(user);
        return "Admin registered successfully.";
    }

    @Override
    public List<UserResponse> getAllUser() {
        return userRepo.findAll().stream()
                .map(user -> UserResponse.builder()
                        .id(user.getUid())
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .password(user.getPassword()) // Include password if necessary
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long id) {
        var user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return UserResponse.builder()
                .id(user.getUid())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .password(user.getPassword()) // Include password if necessary
                .build();
    }

    @Override
    public UserResponse updateUser(Long id, UserResponse userResponse) {
        if (userRepo.existsById(id)) {
            var user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
            user.setName(userResponse.getName());
            user.setEmail(userResponse.getEmail());
            user.setPassword(passwordEncoder.encode(userResponse.getPassword())); // Optionally update password
            user.setRole(userResponse.getRole());
            var updatedUser = userRepo.save(user);
            return UserResponse.builder()
                    .id(updatedUser.getUid())
                    .name(updatedUser.getName())
                    .email(updatedUser.getEmail())
                    .role(updatedUser.getRole())
                    .build();
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
    

    @Override
    public void deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
