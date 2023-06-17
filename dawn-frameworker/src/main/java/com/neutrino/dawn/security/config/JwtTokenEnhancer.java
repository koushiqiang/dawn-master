package com.neutrino.dawn.security.config;

import com.neutrino.dawn.security.bean.LoginUserVo;
import com.neutrino.dawn.security.utils.SecurityUtil;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kousq
 * @Date 2023/05/20 21:17
 * @Version 1.0.0
 * @Description:
 */
public class JwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        LoginUserVo loginUserVo = SecurityUtil.getLoginUser();
        Map<String, Object> additionalInfo = new HashMap<>(1);
        additionalInfo.put("enhance", "enhancer info");
        additionalInfo.put("user", loginUserVo);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
