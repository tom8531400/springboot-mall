package com.lee.springmall.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 會員登入封裝物件
 */
@Data
public class UserLoginRequest {
    // 電子信箱
    @NotBlank
    @Email
    private String email;
    // 密碼
    @NotBlank
    private String password;

    public UserLoginRequest() {
    }

    public UserLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
