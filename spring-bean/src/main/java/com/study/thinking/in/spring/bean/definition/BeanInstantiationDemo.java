package com.study.thinking.in.spring.bean.definition;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: Bean 实例化的示例
 * @author: Dailu
 * @time: 2020/5/29 17:12
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-instantiation-context.xml");

        User user = context.getBean("user-by-static-method", User.class);
        User userByInstantiationMethod = context.getBean("user-by-instantiation-method", User.class);

        System.out.println(user);
        System.out.println(userByInstantiationMethod);
        System.out.println(user == userByInstantiationMethod);

    }
}
