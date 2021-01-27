package com.study.thinking.in.spring.questions;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.function.DoubleToIntFunction;

/**
 * @description: {@link ObjectFactory}  延迟依赖查找示例
 * @author: Dailu
 * @time: 2021/1/27 21:04
 * @see ObjectFactory
 * @see ObjectProvider
 */
public class BeanFactoryLazyLookupDemo {

    @Autowired
    private ObjectProvider<User> objectProvider;

    @Autowired
    private ObjectFactory<User> objectFactory;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(BeanFactoryLazyLookupDemo.class);

        context.refresh();

        BeanFactoryLazyLookupDemo bean = context.getBean(BeanFactoryLazyLookupDemo.class);

        System.out.println(bean.objectFactory == bean.objectProvider);
        System.out.println(bean.objectFactory.getObject() == bean.objectProvider.getObject());

        context.close();

    }

    @Bean
    @Lazy
    public static User getUser(){
        User user = new User();
        user.setId(5L);
        user.setName("Boundless");
        return user;
    }
}
