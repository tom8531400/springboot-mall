package com.lee.springmall.service;

import com.lee.springmall.dto.UserRegisterRequest;
import com.lee.springmall.vo.UserVo;

public interface UserService {

    boolean register(UserRegisterRequest registerRequest);

    UserVo queryUser(String email);
}
