package com.study.thinking.in.spring.annotation;

import org.springframework.context.annotation.Bean;

/**
 * @Description: HelloWorldConfiguration
 * @Author Xiaoyaoyou
 * @Date: 2021/1/20 15:28
 * @Version 1.0
 */

public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "hello World!";
    }
}
