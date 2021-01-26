package com.study.thinking.in.spring.application.context.lifecycle;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.Lifecycle;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;

/**
 * @description: spring shutdown hook 线程 示例
 * @author: Dailu
 * @time: 2021/1/26 21:37
 */
public class SpringShoutDownHookDemo {

    public static void main(String[] args) throws IOException {
        GenericApplicationContext context = new GenericApplicationContext();

        context.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
            @Override
            public void onApplicationEvent(ContextClosedEvent event) {
                System.out.printf("线程【%s】 处理",Thread.currentThread().getName());
            }
        });

        context.refresh();

        context.registerShutdownHook();

        System.out.println("按任意键继续。。。");
        System.in.read();

        context.close();

    }
}
