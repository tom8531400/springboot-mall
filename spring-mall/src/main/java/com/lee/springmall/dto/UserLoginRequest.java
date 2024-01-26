package com.lee.springmall.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    public UserLoginRequest() {
    }

    public UserLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
