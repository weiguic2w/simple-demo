package com.wcw.example.interceptor;

import cn.dev33.satoken.stp.StpUtil;
import com.wcw.example.annotation.LoginIgnore;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MyAuthInterceptor implements HandlerInterceptor {

    static private List<String> writeList;

    // 初始化白名单
    static {
        try(InputStream inputStream = new ClassPathResource("url-writelist.properties").getInputStream()) {
            Properties properties = new Properties();
            properties.load(inputStream);
            writeList = new ArrayList<>(properties.stringPropertyNames());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 过滤白名单
        final String requestPath = request.getServletPath();
        final AntPathMatcher antPathMatcher = new AntPathMatcher();
        for(String writePath : writeList) {
            if(antPathMatcher.match(writePath, requestPath)) {
                return true;
            }
        }

        // 登录校验，微服务satoken需要集成redis判断
        if(handler instanceof HandlerMethod &&
                !((HandlerMethod) handler).hasMethodAnnotation(LoginIgnore.class)) {
            StpUtil.checkLogin();
        }
        return true;
    }
}
