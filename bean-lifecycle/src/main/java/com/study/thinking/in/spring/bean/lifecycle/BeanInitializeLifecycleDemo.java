package com.study.thinking.in.spring.bean.lifecycle;


import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: Bean初始化生命周期示例
 * @Author Xiaoyaoyou
 * @Date: 2020/9/3 18:41
 * @Version 1.0
 */
public class BeanInitializeLifecycleDemo {

    public static void main(String[] args) {
        executeBeanFactory();
    }

    public static void executeBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //添加BeanPostProcessor
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String[] locations = {"META-INF/dependency-lookup-context.xml", "META-INF/bean-constructor-dependency-injection.xml"};
        reader.loadBeanDefinitions(locations);
        beanFactory.preInstantiateSingletons();
        User user = beanFactory.getBean("user", User.class);
        User superUser = beanFactory.getBean("superUser", User.class);
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(user);
        System.out.println(superUser);
        System.out.println(userHolder);
    }


}
