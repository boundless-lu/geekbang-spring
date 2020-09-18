package com.study.thinking.in.spring.configuration.metadata;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import com.study.thinking.in.spring.ioc.overview.enumerate.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.LinkedHashMap;

/**
 * @Description: 基于 Java注解的 YAML 外部化配置示例
 * @Author Xiaoyaoyou
 * @Date: 2020/9/18 11:24
 * @Version 1.0
 */
@PropertySource(name = "yaml",value = "META-INF/user.yaml",factory = YamlPropertySourceFactory.class)
public class AnnotatedYamlPropertySourcesDemo {

    @Bean
    public User user(@Value("${user.id}") Long id, @Value("${user.name}")String name, @Value("${user.city}")City city){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setCity(city);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotatedYamlPropertySourcesDemo.class);
        context.refresh();
        User user = context.getBean("user",User.class);
        System.out.println(user);
        context.close();
    }
}
