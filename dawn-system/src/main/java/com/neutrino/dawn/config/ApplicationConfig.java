package com.neutrino.dawn.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Package: com.neutrino.dawn.config Description: 程序注解
 * Date:  2020/5/17 22:42 Author: kousq Modified By:
 */
@Configuration
@MapperScan({"com.neutrino.dawn.mapper","com.neutrino.dawn.quartz.mapper"})
public class ApplicationConfig {

}
