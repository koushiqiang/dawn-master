package com.neutrino.dawn.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author kousq
 * @Date 2023/05/20 14:24
 * @Version 1.0.0
 * @Description:
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    // 配置资源服务器
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 资源服务器拦截所有请求
        http.authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                // 资源服务器放行指定请求
                .requestMatchers()
                .antMatchers("/user/**");

    }
}
