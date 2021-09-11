package com.mszl.blog.service.impl;

import com.mszl.blog.dao.mapper.SysUserMapper;
import com.mszl.blog.dao.pojo.SysUser;
import com.mszl.blog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null){
            sysUser = new SysUser();
            sysUser.setNickname("永远的匿名大佬");
        }
        return sysUser;
//        return null;
    }
}
