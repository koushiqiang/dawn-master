package com.neutrino.dawn.service.impl;

import com.neutrino.dawn.mapper.SysUserMapper;
import com.neutrino.dawn.model.SysUser;
import com.neutrino.dawn.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.neutrino.dawn.service.impl Description: Date:  2020/5/17 14:03 Author: kousq
 * Modified By:
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    private final SysUserMapper userMapper;

//    使用构造器注入的方法，可以明确成员变量的加载顺序

    @Autowired
    public SysUserServiceImpl(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public SysUser selectUserByLoginName(String userName) {
        return userMapper.selectUserByLoginName(userName);
    }

    @Override
    public SysUser selectUserByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public SysUser selectUserByEmail(String email) {
        return null;
    }

    @Override
    public SysUser selectUserById(Long userId) {
        return null;
    }

    @Override
    public int insertUser(SysUser user) {
        return 0;
    }

    @Override
    public int updateUser(SysUser user) {
        return 0;
    }

    @Override
    public int resetUserPwd(SysUser user) {
        return 0;
    }
}
