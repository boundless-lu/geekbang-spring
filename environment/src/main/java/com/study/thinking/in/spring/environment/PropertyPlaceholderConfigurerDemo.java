package com.study.thinking.in.spring.environment;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @Description: 处理属性占位符示例 {@link PropertyPlaceholderConfigurer}
 * @Author Xiaoyaoyou
 * @Date: 2021/1/20 21:23
 * @Version 1.0
 * @see PropertyPlaceholderConfigurer
 * @see PropertySourcesPlaceholderConfigurer
 */
public class PropertyPlaceholderConfigurerDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/placeholders-resolver.xml");

        final User user = context.getBean(User.class);

        System.out.println(user);

    }
}
