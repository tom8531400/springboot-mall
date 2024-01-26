package com.lee.springmall.service;

import com.lee.springmall.dto.UserLoginRequest;
import com.lee.springmall.dto.UserRegisterRequest;
import com.lee.springmall.vo.UserVo;

public interface UserService {

    boolean register(UserRegisterRequest registerRequest);

    UserVo getUserByEmail(String email);

    UserVo login(UserLoginRequest userLoginRequest);
}
