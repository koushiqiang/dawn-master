package com.neutrino.dawn.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kousq
 * @Date 2023/05/07 15:48
 * @Version 1.0.0
 * @Description: 授权服务器的配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore jwtTokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private JwtTokenEnhancer jwtTokenEnhancer;
    // 授权码模式：配置授权服务器
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 客户端ID 是我们的应用找授权服务器授权的时候需要提供的
                .withClient("client")
                // 密钥
                .secret("secret")
                // 重定向URL
                .redirectUris("http://localhost:8080/login/oauth2/code/dawn")
                // 授权类型 authorization_code 授权码模式
                // password 密码模式
                // refresh_token 刷新token PS:刷新令牌也需要过期时间
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                .refreshTokenValiditySeconds(3600)
                // 自动授权
                .autoApprove(true)
                // 授权范围
                .scopes("all");
        //使用:请求头中授权类型：grant_type:refresh_token;&& refresh_token:刷新令牌
    }

    // 密码模式：配置授权服务器
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        // token增强器链
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);
        delegates.add(jwtAccessTokenConverter);

        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                // 保存token
                .tokenStore(jwtTokenStore)
                // accessToken转换成jwtToken
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(enhancerChain);
    }

    // 实现单点登录的必要配置
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 必须配置身份认证,允许客户端访问 OAuth2 授权接口,否则请求 token 会返回 401
        security.tokenKeyAccess("isAuthenticated()");
    }
}