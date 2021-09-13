package com.mszl.blog.controller;

import com.mszl.blog.service.LoginService;
import com.mszl.blog.service.SysUserService;
import com.mszl.blog.vo.Result;
import com.mszl.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
//    @Autowired
//    private SysUserService sysUserService; //不合适 最好只负责和数据库的交互
    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParam loginParam){
        //登录  验证用户 访问用户表，但是
        return loginService.login(loginParam);
    }
}
