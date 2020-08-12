package com.study.thinking.in.spring.bean.definition;

import com.study.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.study.thinking.in.spring.bean.factory.UserFactory;
import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description: Bean 实例化的示例
 * @author: Dailu
 * @time: 2020/5/29 17:12
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/special-bean-instantiation-context.xml");

        //通过ServiceLoaderFactoryBean获取UserFactory
        ServiceLoader<UserFactory> bean = context.getBean("user-service-loader", ServiceLoader.class);
        displyServiceLoader(bean);

        //通过 AutowireCapableBeanFactory方式创建UserFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
        UserFactory userFactory = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createInstantiationUser());


    }

    public static void demoServiceLoader(){
        ServiceLoader<UserFactory> load = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displyServiceLoader(load);
    }

    public static void  displyServiceLoader(ServiceLoader<UserFactory> load){
        Iterator<UserFactory> iterator = load.iterator();
        while (iterator.hasNext()){
            UserFactory next = iterator.next();
            System.out.println(next.createInstantiationUser());
        }
    }
}
