package com.study.thinking.in.spring.bean.definition;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: Dailu
 * @time: 2020/5/27 18:36
 */
public class BeanNameOfAliasDemo {


    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("/META-INF/spring-bean-context.xml");
        User user = beanFactory.getBean("user", User.class);
        User bean = beanFactory.getBean("dailu-user", User.class);

        System.out.println(user == bean);

    }
}
