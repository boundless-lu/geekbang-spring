package com.study.thinking.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @Description: ResolvableDependencySourceDemo
 * @Author Xiaoyaoyou
 * @Date: 2020/8/28 10:54
 * @Version 1.0
 */
public class ResolvableDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init(){
        System.out.println("executed!");
        System.out.println(value);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //TODO 问题1
        //启动应用上下文
//        context.refresh();
//        AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
//        if (autowireCapableBeanFactory instanceof ConfigurableListableBeanFactory){
//            ConfigurableListableBeanFactory beanFactory = ConfigurableListableBeanFactory.class.cast(autowireCapableBeanFactory);
//            beanFactory.registerResolvableDependency(String.class,"Hello World");
//        }
//        context.register(ResolvableDependencySourceDemo.class);
//        ResolvableDependencySourceDemo bean = context.getBean(ResolvableDependencySourceDemo.class);
//        System.out.println(bean.value);
//        //关闭应用上下文
//        context.close();

        //写法1
//        context.register(ResolvableDependencySourceDemo.class);
//        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        beanFactory.registerResolvableDependency(String.class,"Hello World");
//        context.refresh();
//        context.close();

        //写法2
        context.register(ResolvableDependencySourceDemo.class);
        context.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerResolvableDependency(String.class,"Hello World");
        });
        context.refresh();
        context.close();
    }
}
