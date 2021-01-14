package com.study.thinking.in.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;


/**
 * @description: {@link ApplicationEventPublisher} 示例
 * @author: Dailu
 * @time: 2021/1/14 22:58
 */
public class InjectingApplicationEventPublisherDemo implements ApplicationEventPublisherAware,
        ApplicationContextAware, BeanPostProcessor {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init(){
        //#3
        applicationEventPublisher.publishEvent(new MySpringEvent("The event from @Autowired ApplicationEventPublisher"));
        //#4
        applicationContext.publishEvent(new MySpringEvent("The event from @Autowired ApplicationContext"));
    }

    public static void main(String[] args) {
        //创建spring应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册 Configuration Class
        context.register(InjectingApplicationEventPublisherDemo.class);

        //添加事件监听器
        context.addApplicationListener(new MySpringListener());

        //2.启动spring应用上下文
        context.refresh();

        //4.关闭spring应用上下文
        context.close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //#1
        applicationContext.publishEvent(new MySpringEvent("The event from ApplicationContextAware"));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        //#2
        applicationEventPublisher.publishEvent(new MySpringEvent("The event from ApplicationEventPublisherAware"));
    }
}
