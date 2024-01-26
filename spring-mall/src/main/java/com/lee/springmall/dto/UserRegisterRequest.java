package com.lee.springmall.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 會員註冊封裝物件
 */
@Data
public class UserRegisterRequest {
    // 電子信箱
    @NotBlank
    @Email
    private String email;
    //密碼
    @NotBlank
    private String password;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
