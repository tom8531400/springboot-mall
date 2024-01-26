package com.lee.springmall.service.impl;

import com.lee.springmall.dao.UserMapper;
import com.lee.springmall.dto.UserLoginRequest;
import com.lee.springmall.dto.UserRegisterRequest;
import com.lee.springmall.service.UserService;
import com.lee.springmall.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

/**
 * UserServiceImpl 實作抽象類
 */
@Service
public class UserServiceImpl implements UserService {
    // 定義Logger
    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    /**
     * 會員註冊
     *
     * @param registerRequest Request註冊資料
     * @return 是否註冊成功
     */
    @Override
    public boolean register(UserRegisterRequest registerRequest) {
        UserVo userVo = userMapper.getUserByEmail(registerRequest.getEmail());
        if (userVo != null) {
            log.warn("該email {} 已經被 {} 註冊", registerRequest.getEmail(), "其他使用者");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            String hashedPassword = DigestUtils.md5DigestAsHex(registerRequest.getPassword().getBytes());
            registerRequest.setPassword(hashedPassword);
            return userMapper.createUser(registerRequest);
        }
    }

    /**
     * 依照信箱查詢會員
     *
     * @param email 電子信箱
     * @return 返回查詢結果
     */
    @Override
    public UserVo getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    /**
     * 會員登入
     *
     * @param userLoginRequest Request登入資訊
     * @return 返回登入結果
     */
    @Override
    public UserVo login(UserLoginRequest userLoginRequest) {
        UserVo userVo = userMapper.getUserByEmail(userLoginRequest.getEmail());
        if (userVo == null) {
            log.warn("此信箱 {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());
        if (userVo.getPassword().equals(hashedPassword)) {
            return userVo;
        } else {
            log.warn("此信箱 {} 的密碼輸入不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
