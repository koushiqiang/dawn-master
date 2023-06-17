package com.neutrino.dawn.controller;

import com.dawn.common.basemodel.AjaxResult;
import com.neutrino.dawn.model.SysUser;
import com.neutrino.dawn.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Package: com.dawn.controller.system
 * Description:
 * Date:  2020/3/31 17:33
 * Author: kousq
 * Modified By:
 */
@RestController
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;

    public static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/welcomelogin")
    public String login() {
        System.out.println("welcome!");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/dashboard";
        }
        try {
            request.login(request.getParameter("username"), request.getParameter("password"));
            return "redirect:/dashboard";
        } catch (ServletException e) {
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.logout();
        } catch (ServletException e) {
            // handle exception
        }
        return "redirect:/login?logout=true";
    }
}