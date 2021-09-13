package com.mszl.blog.service;

import com.mszl.blog.dao.pojo.SysUser;
import com.mszl.blog.vo.Result;
import com.mszl.blog.vo.params.LoginParam;

public interface LoginService {
    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);
}
