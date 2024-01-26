package com.lee.springmall.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * 會員基本資料
 * 建表日期 112/01/26
 */

@Data
public class UserVo {
    // 會員編號
    private Integer user_id;
    // 電子信箱
    private String email;
    // 會員密碼
    @JsonIgnore
    private String password;
    // 建立日期
    private Date created_date;
    // 最後修改日期
    private Date lastModified_date;

    public UserVo() {
    }

    public UserVo(Integer user_id, String email, String password, Date created_date, Date lastModified_date) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.created_date = created_date;
        this.lastModified_date = lastModified_date;
    }
}
