package com.study.thinking.in.spring.ioc.dependency.injection;

import com.study.thinking.in.spring.ioc.dependency.injection.annotation.UserGroup;
import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * @Description: Qualifier(限定名称)依赖注入;Qualifier划分分组;扩展（继承）Qualifier注解
 * @Author Xiaoyaoyou
 * @Date: 2020/8/25 10:06
 * @Version 1.0
 */
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    @Qualifier("user")
    private User namedUser;

    @Autowired
    private Collection<User> users;

    @Autowired
    @Qualifier
    private Collection<User> qualifierUsers;

    @Autowired
    @UserGroup
    private Collection<User> userGroupUsers;


    @Bean
    @Qualifier
    private User user1(){
        return createUser(7L);
    }

    @Bean
    @Qualifier
    private User user2(){
        return createUser(8L);
    }

    @Bean
    @UserGroup
    private User user3(){
        return createUser(9L);
    }

    @Bean
    @UserGroup
    private User user4(){
        return createUser(10L);
    }

    private static User createUser(Long id){
        User user = new User();
        user.setId(id);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(QualifierAnnotationDependencyInjectionDemo.class);

        //设置Bean注册中心
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String path = "META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(path);


        //启动应用上下文
        context.refresh();

        QualifierAnnotationDependencyInjectionDemo demo = context.getBean(QualifierAnnotationDependencyInjectionDemo.class);
//        System.out.println(demo.user);
//        System.out.println(demo.namedUser);


        System.out.println(demo.users);
        System.out.println(demo.qualifierUsers);
        System.out.println(demo.userGroupUsers);
        //关闭应用上下文
        context.close();
    }


}
