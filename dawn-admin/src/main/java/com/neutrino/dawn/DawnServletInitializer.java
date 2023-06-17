package com.neutrino.dawn;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Package: PACKAGE_NAME
 * Description:
 * Date:  2020/3/31 16:48
 * Author: kousq
 * Modified By:
 */
public class DawnServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DawnApplication.class);
    }


}
