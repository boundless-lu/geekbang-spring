package com.study.thinking.in.spring.ioc.dependency.injection;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Description: 基于注解的依赖 Setter方法注入示例
 * @Author Xiaoyaoyou
 * @Date: 2020/8/6 17:44
 * @Version 1.0
 */
public class AnnotationDependencySetterInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencySetterInjectionDemo.class);

        //设置Bean注册中心
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String path = "META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(path);


        //启动应用上下文
        context.refresh();


        UserHolder bean = context.getBean(UserHolder.class);
        System.out.println(bean);

        //关闭应用上下文
        context.close();
    }

    @Bean
    private UserHolder userHolder(User user){
        UserHolder userHolder = new UserHolder(user);
        return userHolder;
    }
}
