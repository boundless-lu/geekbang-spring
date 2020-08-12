package com.study.thinking.in.spring.dependency.exception;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoSuchBeanDefinitionExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(NoSuchBeanDefinitionExceptionDemo.class);
        context.refresh();
        context.getBean("aaa");
        context.close();
    }
}
