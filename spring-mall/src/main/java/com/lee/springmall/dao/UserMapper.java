package com.lee.springmall.dao;

import com.lee.springmall.dto.UserRegisterRequest;
import com.lee.springmall.vo.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper {
    // 新增會員
    @Insert("insert into user(email,password)values(#{registerRequest.email},#{registerRequest.password})")
    boolean createUser(@Param("registerRequest") UserRegisterRequest registerRequest);

    // 依照email來查詢會員資訊
    @Select("select * from user where email = #{email}")
    UserVo getUserByEmail(@Param("email") String email);
}
