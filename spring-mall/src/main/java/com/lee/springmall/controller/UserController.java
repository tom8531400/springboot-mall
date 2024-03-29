package com.lee.springmall.controller;

import com.lee.springmall.dto.UserLoginRequest;
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

/**
 * UserController會員控制項
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 會員註冊
     *
     * @param registerRequest 會員註冊封裝物件
     * @return 返回註冊資訊
     */
    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public ResponseEntity<UserVo> register(@RequestBody @Valid UserRegisterRequest registerRequest) {
        boolean register = userService.register(registerRequest);
        if (register) {
            UserVo userVo = userService.getUserByEmail(registerRequest.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(userVo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * 會員登入
     *
     * @param userLoginRequest 會員登入封裝物件
     * @return 返回登入資訊
     */
    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public ResponseEntity<UserVo> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        UserVo userVo = userService.login(userLoginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userVo);
    }

}
