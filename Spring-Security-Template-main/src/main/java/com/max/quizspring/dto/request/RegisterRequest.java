package com.max.quizspring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegisterRequest {
    private String UserName;
    private String email;
    private String password;
    // private String phone;
    // private String address;
}