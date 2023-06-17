package com.dawn.common.utils;

import cn.hutool.core.io.resource.ClassPathResource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Package: com.dawn.common.utils Description: 读取application.properties配置文件工具类 Date:  2020/5/17
 * 22:11 Author: kousq Modified By:
 */
public class propertiesUtil {

    public static Map LoadProperties(String fileName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        InputStream in = classPathResource.getStream();
        Properties props = new Properties();
        props.load(new InputStreamReader(in, "UTF-8"));
        Map<String, String> map = new HashMap<String, String>((Map) props);
        return map != null ? map : null;
    }


}
