package com.lee.springmall.service.impl;

import com.lee.springmall.dao.UserMapper;
import com.lee.springmall.dto.UserRegisterRequest;
import com.lee.springmall.service.UserService;
import com.lee.springmall.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean register(UserRegisterRequest registerRequest) {
        UserVo userVo = userMapper.getUserByEmail(registerRequest.getEmail());
        if (userVo != null) {
            log.warn("該email {} 已經被 {} 註冊",registerRequest.getEmail(),"其他使用者");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return userMapper.createUser(registerRequest);
        }
    }

    @Override
    public UserVo getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }
}
