package com.study.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 注解驱动异步事件处理 示例
 * @author: Dailu
 * @time: 2021/1/14 21:54
 */
@EnableAsync
public class AnnotatedAsyncEventHandlerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //1.注册当前类作为 Configuration class
        context.register(AnnotatedAsyncEventHandlerDemo.class);

        //2.启动spring应用上下文
        context.refresh();//初始化 ApplicationEventMulticaster

        //3.发布自定义spring事件
        context.publishEvent(new MySpringEvent("Hello SimpleApplicationEventMulticaster!"));

        //4.关闭spring应用上下文
        context.close();
    }

    @Async
    @EventListener
    public void onEvent(MySpringEvent event){
        System.out.printf("[监听线程：%s]onEvent方法监听到事件：%s\n", Thread.currentThread().getName(), event);
    }

    @Bean
    public Executor taskExecutor(){
        ExecutorService taskService = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("Listener-thread-pool-@Async"));
        return taskService;
    }
}
