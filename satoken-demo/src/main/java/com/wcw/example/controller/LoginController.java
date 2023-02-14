package com.wcw.example.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.wcw.example.annotation.LoginIgnore;
import com.wcw.example.model.dto.AuthParamDto;
import com.wcw.example.model.pojo.User;
import com.wcw.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录测试
 */
@RestController
@RequestMapping("/auth/")
public class LoginController {
    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("login")
    public String doLogin() {
        StpUtil.login(1L);
        return "用户已登录";
        //final AuthService authService = applicationContext.getBean(authParamDto.getAuthType() + "AuthType", AuthService.class);
        //User user = authService.execute(authParamDto);
        //return SaResult.ok().setData(user);
    }

    @SaIgnore
    @RequestMapping("logout")
    public String logout() {
        StpUtil.logout();
        return "用户退出登陆";
    }

    @LoginIgnore
    @RequestMapping("annotation")
    public String annotationTest() {
        return "annotationIgnoreTest";
    }

    @RequestMapping("writeUrl")
    public String urlTest() {
        return "writeUrl";
    }

    @RequestMapping("isLogin")
    public String tokenTest() {
        return "tokenTest";
    }
}
