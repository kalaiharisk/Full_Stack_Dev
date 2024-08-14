package com.example.demo.dto.response;

import com.example.demo.enums.Role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private String password;
    public Object map(Object object) {
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }
}