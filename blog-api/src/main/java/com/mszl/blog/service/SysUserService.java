package com.mszl.blog.service;

import com.mszl.blog.dao.pojo.SysUser;
import com.mszl.blog.vo.Result;

public interface SysUserService {

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);
}
