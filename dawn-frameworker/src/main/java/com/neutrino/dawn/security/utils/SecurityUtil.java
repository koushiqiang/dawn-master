package com.neutrino.dawn.security.utils;

import com.neutrino.dawn.security.bean.LoginUserVo;

/**
 * @author kousq
 * @Date 2023/05/20 21:18
 * @Version 1.0.0
 * @Description:
 */
public class SecurityUtil {
    public static LoginUserVo getLoginUser() {
//        LoginUserVo loginUserVo = LoginUserContextHolder.getLoginUserContext();
        LoginUserVo loginUserVo = new LoginUserVo();
        // TODO 前端处理登录用户信息Header前，临时使用固定用户ID
        if (loginUserVo == null) {
            loginUserVo = new LoginUserVo();
            loginUserVo.setUserSysId("6816f79cc0a8016401c5a33be04be441");
        }
        // 临时将语言设置为中文
        loginUserVo.setPreferredLanguage("zh");
        return loginUserVo;
    }
}