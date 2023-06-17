package com.neutrino.dawn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Package: com.neutrino.dawn.config Description:首页  &  默认配置文件加载
 * Date:  2020/5/17 16:01 Author: kousq Modified By:
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {

    /**
     * 首页地址
     */
    @Value("${dawn.user.indexUrl}")
    private String indexUrl;

    /**
     * 默认首页的设置，当输入域名是可以自动跳转到默认指定的网页
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:" + indexUrl);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 文件上传路径
        registry.addResourceHandler("/profile/**")
                .addResourceLocations("file:" + Global.getProfile());

    }
}