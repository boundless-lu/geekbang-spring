package com.study.thinking.in.spring.ioc.overview.dependency.injection;

import com.study.thinking.in.spring.ioc.overview.annotation.Super;
import com.study.thinking.in.spring.ioc.overview.domain.SuperUser;
import com.study.thinking.in.spring.ioc.overview.domain.User;
import com.study.thinking.in.spring.ioc.overview.repository.UserRepository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class DependencyInjectionDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        UserRepository userRepository = (UserRepository)beanFactory.getBean("userRepository");

        //依赖来源1：自定义bean
        System.out.println(userRepository.getUsers());

        //依赖来源2：spring内建的依赖
        System.out.println(userRepository.getBeanFactory());

        //依赖来源3：spring容器内建的bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);


        System.out.println(userRepository.getAppCon().getObject().equals(beanFactory));
    }

}
