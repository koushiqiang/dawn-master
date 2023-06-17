package com.neutrino.dawn.controller;

import com.neutrino.dawn.model.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Package: com.neutrino.dawn.controller Description: Date:  2020/5/18 0:23 Author: kousq Modified
 * By:
 */
@Controller
public class SysIndexController {

    /**
     * 系统首页
     *
     * @param mmap ModelMap
     * @return
     */
    @GetMapping("/index")
    public String index(ModelMap mmap, SysUser sysUser) {
        // 根据用户id取出菜单

        return "index";
    }
}
