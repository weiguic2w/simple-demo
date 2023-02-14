package com.wcw.example.annotation;

import java.lang.annotation.*;

/**
 * 访问白名单注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginIgnore {
}