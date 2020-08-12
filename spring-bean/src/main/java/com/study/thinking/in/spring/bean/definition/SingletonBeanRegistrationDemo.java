package com.study.thinking.in.spring.bean.definition;

import com.study.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.study.thinking.in.spring.bean.factory.UserFactory;
import com.study.thinking.in.spring.bean.factory.UserFactoryBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: 单体Bean 注册 实例
 * @author: Dailu
 * @time: 2020/6/5 18:04
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SingletonBeanRegistrationDemo.class);
        context.refresh();

        //单体Bean,即不受spring管理的Bean
        UserFactory factory = new DefaultUserFactory() ;

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        //注册单体Bean
        beanFactory.registerSingleton("userFactory",factory);

        //依赖查找
        DefaultUserFactory userFactory = beanFactory.getBean("userFactory", DefaultUserFactory.class);

        System.out.println(factory == userFactory);
        context.close();
    }
}
