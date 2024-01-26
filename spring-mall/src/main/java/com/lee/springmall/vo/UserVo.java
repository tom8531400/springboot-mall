package com.lee.springmall.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVo {
    private Integer user_id;
    private String email;
    private String password;
    private Date created_date;
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
