package com.study.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Description: AutoWiringDependencySetterInjectionDemo
 * @Author Xiaoyaoyou
 * @Date: 2020/8/6 18:20
 * @Version 1.0
 */
public class AutoWiringDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String path = "META-INF/autowiring-dependency-setter-injection.xml";

        reader.loadBeanDefinitions(path);

        UserHolder bean = beanFactory.getBean(UserHolder.class);
        System.out.println(bean);
    }
}
