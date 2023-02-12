package com.wcw.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ChuangWeiwei;
 * @create 2023.01.24  21:32;
 */
@SpringBootApplication
@ComponentScan("com.wcw")
public class WsDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(WsDemoApplication.class, args);
    }
}
