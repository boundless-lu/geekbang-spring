package com.study.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: 模块注解驱动示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/20 15:18
 * @Version 1.0
 */
@EnableHelloWorld
public class EnableModuleDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册 configuration class
        context.register(EnableModuleDemo.class);

        //启动spring应用上下文
        context.refresh();

        final String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);

        //关闭spring应用上下文
        context.close();
    }
}
