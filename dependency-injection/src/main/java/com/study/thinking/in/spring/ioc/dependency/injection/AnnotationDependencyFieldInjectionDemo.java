package com.study.thinking.in.spring.ioc.dependency.injection;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @Description: 基于注解的依赖 字段注入示例
 * @Author Xiaoyaoyou
 * @Date: 2020/8/12 17:55
 * @Version 1.0
 */
public class AnnotationDependencyFieldInjectionDemo {

    @Autowired  //@Autowired注解会忽略掉静态字段
    private UserHolder userHolder1;

    @Resource //@Resource注解静态字段会报错
    private UserHolder userHolder2;

    @Inject //@Inject注解会忽略掉静态字段
    private static UserHolder userHolder3;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyFieldInjectionDemo.class);

        //设置Bean注册中心
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String path = "META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(path);


        //启动应用上下文
        context.refresh();


        AnnotationDependencyFieldInjectionDemo demo = context.getBean(AnnotationDependencyFieldInjectionDemo.class);
        System.out.println(demo.userHolder1);
        System.out.println(demo.userHolder2);
        System.out.println(demo.userHolder3);
        System.out.println(demo.userHolder1 == demo.userHolder2);
        System.out.println(demo.userHolder1 == demo.userHolder3);

        //关闭应用上下文
        context.close();
    }

    @Bean
    private UserHolder userHolder(User user){
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }
}
