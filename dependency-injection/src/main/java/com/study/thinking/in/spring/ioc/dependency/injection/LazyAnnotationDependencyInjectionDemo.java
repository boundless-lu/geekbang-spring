package com.study.thinking.in.spring.ioc.dependency.injection;

import com.study.thinking.in.spring.ioc.dependency.injection.annotation.UserGroup;
import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Set;

/**
 * @Description: 延迟注入
 * @Author Xiaoyaoyou
 * @Date: 2020/8/25 10:06
 * @Version 1.0
 */
public class LazyAnnotationDependencyInjectionDemo {

    @Autowired
    private ObjectProvider<User> userObjectProvider;

    @Autowired
    private ObjectFactory<User> userObjectFactory;

    @Autowired
    private ObjectFactory<Set<User>> collectionObjectFactory;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LazyAnnotationDependencyInjectionDemo.class);

        //设置Bean注册中心
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String path = "META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(path);

        //启动应用上下文
        context.refresh();

        LazyAnnotationDependencyInjectionDemo demo = context.getBean(LazyAnnotationDependencyInjectionDemo.class);


        System.out.println(demo.userObjectProvider.getObject());//继承自ObjectFactory的getObject()方法
        System.out.println(demo.userObjectFactory.getObject());
        System.out.println("==================================");
        demo.userObjectProvider.forEach(System.out::println);
        System.out.println("==================================");
        System.out.println(demo.collectionObjectFactory.getObject());
        //关闭应用上下文
        context.close();
    }


}
