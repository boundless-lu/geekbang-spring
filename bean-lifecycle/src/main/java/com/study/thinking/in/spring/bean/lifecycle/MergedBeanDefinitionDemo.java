package com.study.thinking.in.spring.bean.lifecycle;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Description: BeanDefinition 合并示例
 * @Author Xiaoyaoyou
 * @Date: 2020/9/3 15:02
 * @Version 1.0
 */
public class MergedBeanDefinitionDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(location);
        User user = beanFactory.getBean("user", User.class);
        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(user);
        System.out.println(superUser);
    }
}
