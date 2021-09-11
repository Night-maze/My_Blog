package com.mszl.blog.service;

import com.mszl.blog.dao.pojo.SysUser;

public interface SysUserService {

    SysUser findUserById(Long id);
}
