package com.study.thinking.in.spring.bean.lifecycle;


import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: Bean实例化生命周期示例
 * @Author Xiaoyaoyou
 * @Date: 2020/9/3 18:41
 * @Version 1.0
 */
public class BeanInstantiationLifecycleDemo {

    public static void main(String[] args) {
        executeBeanFactory();
        System.out.println("=============================================================");
        executeApplicationContext();
    }

    public static void executeBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //添加BeanPostProcessor
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};
        reader.loadBeanDefinitions(locations);
        User user = beanFactory.getBean("user", User.class);
        User superUser = beanFactory.getBean("superUser", User.class);
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(user);
        System.out.println(superUser);
        System.out.println(userHolder);
    }

    public static void executeApplicationContext(){
        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(locations);
//        context.refresh();
        User user = context.getBean("user", User.class);
        User superUser = context.getBean("superUser", User.class);
        UserHolder userHolder = context.getBean("userHolder", UserHolder.class);
        System.out.println(user);
        System.out.println(superUser);
        System.out.println(userHolder);
        context.close();
    }


}
