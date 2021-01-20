package com.study.thinking.in.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @Description: 自定义注解 {@link Component} 注解的“派生性”
 * @Author Xiaoyaoyou
 * @Date: 2021/1/19 19:49
 * @Version 1.0
 * @see Component
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponent1
public @interface MyComponent2 {
}
