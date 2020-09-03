package com.study.thinking.in.spring.bean.lifecycle;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @description:
 * @author: Dailu
 * @time: 2020/9/1 21:29
 */
public class BeanMetadataConfigurationDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        String local = "META-INF/user.properties";
        Resource resource = new ClassPathResource(local);
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
        int count = reader.loadBeanDefinitions(encodedResource);
        System.out.println("加载了"+count+"个元数据");

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

    }
}
