package com.study.thinking.in.spring.ioc.dependency.injection;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @Description: 基于注解的依赖 方法注入示例
 * @Author Xiaoyaoyou
 * @Date: 2020/8/12 17:55
 * @Version 1.0
 */
public class AnnotationDependencyMethodInjectionDemo {

    private UserHolder userHolder1;

    private UserHolder userHolder2;

    private static UserHolder userHolder3;

    @Autowired
    private void init1(UserHolder userHolder){
        this.userHolder1 = userHolder;
    }

    @Resource
    private void init2(UserHolder userHolder){
        this.userHolder2 = userHolder;
    }

    @Inject
    private void init3(UserHolder userHolder){
        this.userHolder3 = userHolder;
    }


    @Bean
    private UserHolder userHolder(User user){
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyMethodInjectionDemo.class);

        //设置Bean注册中心
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String path = "META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(path);


        //启动应用上下文
        context.refresh();


        AnnotationDependencyMethodInjectionDemo demo = context.getBean(AnnotationDependencyMethodInjectionDemo.class);
        System.out.println(demo.userHolder1);
        System.out.println(demo.userHolder2);
        System.out.println(demo.userHolder3);
        System.out.println(demo.userHolder1 == demo.userHolder2);
        System.out.println(demo.userHolder1 == demo.userHolder3);

        //关闭应用上下文
        context.close();
    }

}
