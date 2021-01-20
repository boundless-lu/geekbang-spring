package com.study.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description: 条件注解 {@link Profile} 示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/20 16:45
 * @Version 1.0
 * @see Profile
 */
public class ProfileDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册 configuration class
        context.register(ProfileDemo.class);

        //获取Environment对象，可配置的
        final ConfigurableEnvironment environment = context.getEnvironment();
        //设置默认profile【odd】，兜底方案
        environment.setDefaultProfiles("odd");
        //设置活跃profile【even】
        environment.setActiveProfiles("even");

        //启动spring应用上下文
        context.refresh();


        final Integer number = context.getBean("number", Integer.class);
        System.out.println(number);

        //关闭spring应用上下文
        context.close();

    }

    //    @Profile("even")
    @Conditional(EvenProfileCondition.class)
    @Bean(name = "number")
    public Integer even() {
        return Integer.valueOf("2");
    }

    @Profile("odd")
    @Bean(name = "number")
    public Integer odd() {
        return Integer.valueOf("1");
    }

}
