package com.study.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Description: 基于XML资源的依赖 Setter方法注入示例
 * @Author Xiaoyaoyou
 * @Date: 2020/8/6 17:05
 * @Version 1.0
 */
public class XmlDependencySetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String path = "META-INF/dependency-setter-injection.xml";

        reader.loadBeanDefinitions(path);

        UserHolder bean = beanFactory.getBean(UserHolder.class);
        System.out.println(bean);


    }
}
