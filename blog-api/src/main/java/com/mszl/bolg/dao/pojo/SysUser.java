package com.mszl.bolg.dao.pojo;

import lombok.Data;

import javax.xml.soap.SAAJResult;
@Data
public class SysUser {
    private Long id;
    private String account;
    private Integer admin;
    private String avatar;
    private Long createDate;
    private Integer delete;
    private String email;
    private Long lastLogin;
    private String mobilePhoneNumber;
    private String nickname;
    private String password;
    private String salt;
    private String status;

}
