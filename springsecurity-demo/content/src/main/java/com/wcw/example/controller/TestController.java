package com.wcw.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChuangWeiwei;
 * @create 2023.02.12  20:46;
 */
@RestController
public class TestController {
    @GetMapping("/private/test")
    @PreAuthorize("hasAuthority('private')")//拥有p2权限方可访问
    public String test() {
        return "HERE IS PRIVATE METHOD";
    }

    @GetMapping("/public/test")
    //@PreAuthorize("hasAuthority('public')")
    public String publicTest() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().toString());
        return "here is public method";
    }
}
