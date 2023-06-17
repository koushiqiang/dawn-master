package com.neutrino.dawn.service;

import com.neutrino.dawn.model.SysUser;

/**
 * Package: com.neutrino.dawn.service Description: Date:  2020/5/17 13:39 Author: kousq Modified
 * By:
 */

public interface ISysUserService {
/**
 * @description:根据姓名查询
 * @param: [userName]
 * @return: com.neutrino.dawn.model.SysUser
 * @auther: kousq
 * @date: 2020/5/17 13:58
 */
    SysUser selectUserByLoginName(String userName);

/**
 * @description:根据手机号查询
 * @param: [phoneNumber]
 * @return: com.neutrino.dawn.model.SysUser
 * @auther: kousq
 * @date: 2020/5/17 13:59
 */
    SysUser selectUserByPhoneNumber(String phoneNumber);

/**
 * @description:根据邮箱查询
 * @param: [email]
 * @return: com.neutrino.dawn.model.SysUser
 * @auther: kousq
 * @date: 2020/5/17 13:59
 */
    SysUser selectUserByEmail(String email);

/**
 * @description:根据用户id查询
 * @param: [userId]
 * @return: com.neutrino.dawn.model.SysUser
 * @auther: kousq
 * @date: 2020/5/17 14:00
 */
    SysUser selectUserById(Long userId);

/**
 * @description:新增用户
 * @param: [user]
 * @return: int
 * @auther: kousq
 * @date: 2020/5/17 14:01
 */
    int insertUser(SysUser user);

/**
 * @description:更新用户信息
 * @param: [user]
 * @return: int
 * @auther: kousq
 * @date: 2020/5/17 14:01
 */
    int updateUser(SysUser user);

    /**
     * @description:重置密码
     * @param: [user]
     * @return: int
     * @auther: kousq
     * @date: 2020/5/17 14:02
     */
    int resetUserPwd(SysUser user);

}
