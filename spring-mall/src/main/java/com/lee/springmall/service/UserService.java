package com.lee.springmall.service;

import com.lee.springmall.dto.UserLoginRequest;
import com.lee.springmall.dto.UserRegisterRequest;
import com.lee.springmall.vo.UserVo;

/**
 * UserService 抽象類
 */
public interface UserService {
    // 會員註冊
    boolean register(UserRegisterRequest registerRequest);

    // 依照信箱查詢會員
    UserVo getUserByEmail(String email);

    // 會員登入
    UserVo login(UserLoginRequest userLoginRequest);
}
