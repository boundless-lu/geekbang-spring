package com.study.thinking.in.spring.event;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @description: spring 自定义事件处理
 * @author: Dailu
 * @time: 2021/1/14 21:54
 */
public class CustomizedSpringEventDemo {

    public static void main(String[] args) {

        GenericApplicationContext context = new GenericApplicationContext();

        //1.添加自定义spring事件监听器
        context.addApplicationListener(new MySpringListener());

        //2.启动spring应用上下文
        context.refresh();

        //3.发布自定义spring事件
        context.publishEvent(new MySpringEvent("hello World!"));

        //4.关闭spring应用上下文
        context.close();
    }
}
