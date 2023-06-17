package com.neutrino.dawn.mapper;

import com.neutrino.dawn.model.SysUser;

/**
 * Package: com.neutrino.dawn.mapper Description: Date:  2020/5/17 14:43 Author: kousq Modified By:
 */
public interface SysUserMapper {
/**
 * @description:通过用户名查询用户
 * @param: [userName]
 * @return: com.neutrino.dawn.model.SysUser
 * @auther: kousq
 * @date: 2020/5/17 14:43
 */
    SysUser selectUserByLoginName(String userName);


/**
 * @description:通过手机号码查询用户
 * @param: [phoneNumber]
 * @return: com.neutrino.dawn.model.SysUser
 * @auther: kousq
 * @date: 2020/5/17 14:43
 */
//    SysUser selectUserByPhoneNumber(String phoneNumber);


    /**
     * @description:通过邮箱查询用户
     * @param: [email]
     * @return: com.neutrino.dawn.model.SysUser
     * @auther: kousq
     * @date: 2020/5/17 14:44
     */
//    SysUser selectUserByEmail(String email);

    /**
     * @description:通过用户ID查询用户
     * @param: [userId]
     * @return: com.neutrino.dawn.model.SysUser
     * @auther: kousq
     * @date: 2020/5/17 14:44
     */
//    SysUser selectUserById(Long userId);

/**
 * @description:新增用户信息
 * @param: [user]
 * @return: int
 * @auther: kousq
 * @date: 2020/5/17 14:45
 */
//    int insertUser(SysUser user);
    /**
     * @description:通过用户ID删除用户
     * @param: [userId]
     * @return: int
     * @auther: kousq
     * @date: 2020/5/17 14:44
     */
/**
 * @description:修改用户信息
 * @param: [user]
 * @return: int
 * @auther: kousq
 * @date: 2020/5/17 14:45
 */
//    int updateUser(SysUser user);

    /**
     * @description:通过用户ID删除用户
     * @param: [userId]
     * @return: int
     * @auther: kousq
     * @date: 2020/5/17 14:45
     */
//    int deleteUserById(Long userId);



}
