package com.lee.springmall.service.impl;

import com.lee.springmall.dao.UserMapper;
import com.lee.springmall.dto.UserRegisterRequest;
import com.lee.springmall.service.UserService;
import com.lee.springmall.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean register(UserRegisterRequest registerRequest) {
        return userMapper.createUser(registerRequest);
    }

    @Override
    public UserVo queryUser(String email) {
        return userMapper.queryUser(email);
    }
}
