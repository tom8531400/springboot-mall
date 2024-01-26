package com.lee.springmall.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegisterRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
