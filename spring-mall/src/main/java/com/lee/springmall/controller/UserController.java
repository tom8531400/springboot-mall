package com.lee.springmall.controller;

import com.lee.springmall.dto.UserRegisterRequest;
import com.lee.springmall.service.UserService;
import com.lee.springmall.vo.UserVo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public ResponseEntity<UserVo> register(@RequestBody @Valid UserRegisterRequest registerRequest) {
        boolean register = userService.register(registerRequest);
        if (register) {
            UserVo userVo = userService.queryUser(registerRequest.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(userVo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
