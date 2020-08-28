package com.study.thinking.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @Description: ExternalConfigurationDependencySourceDemo
 * @Author Xiaoyaoyou
 * @Date: 2020/8/28 17:41
 * @Version 1.0
 */

@Configuration
@PropertySource(value = "META-INF/default.properties",encoding = "UTF-8")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id:1}")
    private Long id;

    @Value("${usr.name:wang}")
    private String name;


    @Value("${user.localResource:xxx}")
    private Resource resource;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ExternalConfigurationDependencySourceDemo.class);

        //启动应用上下文
        context.refresh();

        ExternalConfigurationDependencySourceDemo demo = context.getBean(ExternalConfigurationDependencySourceDemo.class);
        System.out.println("user.id= "+demo.id);
        System.out.println("user.name= "+demo.name);
        System.out.println("user.resource= "+demo.resource);

        //关闭应用上下文
        context.close();
    }
}
