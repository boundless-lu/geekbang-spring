package com.study.thinking.in.spring.questions;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @description: Bean 的缓存示例
 * @author: Dailu
 * @time: 2021/1/27 21:04
 * @see ObjectFactory
 * @see ObjectProvider
 */
public class BeanCachingDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(BeanCachingDemo.class);

        context.refresh();

        context.close();

    }

    //单例Bean会缓存，原型Bean不会缓存  具体还是要看scope的作用域
    @Bean
//    @Scope("prototype") //原型Bean不会缓存,创建完后与容器脱钩
//    @Scope("request") //request作用域缓存
    public static User getUser(){
        User user = new User();
        user.setId(5L);
        user.setName("Boundless");
        return user;
    }
}
