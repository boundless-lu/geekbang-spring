package com.study.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description: {@link ApplicationListener} spring事件监听示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/14 11:31
 * @Version 1.0
 *
 * @see ApplicationListener
 */
@EnableAsync
public class ApplicationListenerDemo  implements ApplicationEventPublisherAware {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ApplicationListenerDemo.class);

        //方法一：基于spring接口，向spring应用上下文注册监听事件
        // a方法；基于ConfigurableApplicationContext  API 实现
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                println("{基于接口}"+event);
            }
        });

        //方法一：
        // b方法：基于ApplicationListener注册为spring Bean
        //通过 Configuration Class 注册
        context.register(MyApplicationListener.class);

        //方法二：基于spring注解 org.springframework.context.event.EventListener  实现

        //启动 spring 应用上下文
        context.refresh();
        context.start();
        //关闭spring 应用上下文
        context.close();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new ApplicationEvent("hello World!") {
        });

        applicationEventPublisher.publishEvent("hello World!!!");
    }

    static class MyApplicationListener implements ApplicationListener<ContextStartedEvent>{

        @Override
        public void onApplicationEvent(ContextStartedEvent event) {
            println("{基于MyApplicationListener}{ContextStartedEvent}");
        }
    }

    @EventListener
    @Order(1)
    public void onApplicationEvent1(ContextRefreshedEvent event){
        println("{基于@EventListener注解}{@Order排序1}{ContextRefreshedEvent}");
    }

    @EventListener
    @Order(2)
    public void onApplicationEvent2(ContextRefreshedEvent event){
        println("{基于@EventListener注解}{@Order排序2}{ContextRefreshedEvent}");
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event){
        println("{基于@EventListener注解}{ContextClosedEvent}");
    }

    @EventListener
    @Async
    public void onApplicationEvent(ContextStartedEvent event){
        println("{基于@EventListener注解}{@Async异步}{ContextStartedEvent}");
    }

    public static void println(Object args){
        System.out.printf("[%s]:接收到spring事件-->%s\n",Thread.currentThread().getName(),args);
    }
}
