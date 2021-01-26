package com.study.thinking.in.spring.application.context.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static org.springframework.context.support.LiveBeansView.MBEAN_DOMAIN_PROPERTY_NAME;

/**
 * @Description: LiveBeansViewDemo
 * @Author Xiaoyaoyou
 * @Date: 2021/1/25 21:47
 * @Version 1.0
 */
public class LiveBeansViewDemo {

    public static void main(String[] args) throws IOException {

        //添加LiveBeansView 的 ObjectName 的 domain    JMX相关概念
        System.setProperty(MBEAN_DOMAIN_PROPERTY_NAME,"com.study.thinking.in.spring");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(LiveBeansViewDemo.class);

        context.refresh();

        System.out.println("按任意键继续...");
        System.in.read();


        context.close();
    }
}
