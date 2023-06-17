package com.neutrino.dawn.security.bean;

import java.io.Serializable;


/**
 * @Description:登录用户的VO
 *
 */
public class LoginUserVo implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 登录用户Sys Id
     */
    private String userSysId;

    /**
     * 用户登录ID
     */
    private String userName;

    /**
     * 用户登录密码
     */
    private String userPassword;

    /**
     * 用户语言
     */
    private String preferredLanguage;

    /**
     * 用户头像
     */
    private String avatar;

    private String mfaType;


    /**
     * 默认构造方法
     */
    public LoginUserVo() {

    }

    public String getUserSysId() {
        return userSysId;
    }

    public void setUserSysId(String userSysId) {
        this.userSysId = userSysId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getMfaType() {
        return mfaType;
    }

    public void setMfaType(String mfaType) {
        this.mfaType = mfaType;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
