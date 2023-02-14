package com.wcw.example.config;

import com.wcw.example.interceptor.MyAuthInterceptor;
import com.wcw.example.interceptor.MyAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ChuangWeiwei;
 * @create 2023.02.14  10:59;
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyAuthInterceptor()).
                addPathPatterns("/**");
    }
}
