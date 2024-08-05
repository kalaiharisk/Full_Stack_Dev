package com.example.shiftflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.shiftflow.repo.UserRepo;
import com.example.shiftflow.service.AuthService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                                .requestMatchers("/api/schedule/**").hasAnyRole("ADMIN", "STAFF")
                                .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll())
                .logout(logout -> logout
                        .permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepo userRepo) {
        return new AuthService(userRepo, passwordEncoder()); // Make sure AuthService is correctly instantiated
    }
}
