package com.study.thinking.in.spring.configuration.metadata;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * @Description: PropertiesBeanDefinitionReaderDemo
 * @Author Xiaoyaoyou
 * @Date: 2020/9/17 10:50
 * @Version 1.0
 */
public class PropertiesBeanDefinitionReaderDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        String path = "META-INF/user.properties";
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource(path);
        EncodedResource encodedResource =  new EncodedResource(resource,"UTF-8");
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        int count = reader.loadBeanDefinitions(encodedResource);
        System.out.println(String.format("已加载 %d 个BeanDefinition \n",count));
        User bean = beanFactory.getBean(User.class);
        System.out.println(bean);
    }
}
