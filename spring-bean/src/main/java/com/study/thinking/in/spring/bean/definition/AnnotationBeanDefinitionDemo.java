package com.study.thinking.in.spring.bean.definition;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.net.UnknownServiceException;

/**
 * @description: 注解 Bean Definition 示例
 * @author: Dailu
 * @time: 2020/5/27 20:38
 */

@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AnnotationBeanDefinitionDemo.class);

        //命名方式注册Spring Bean (User.class)
        registerUserBeanDefinition(app,"xiaoyaoyou");
        //非命名方式注册Spring Bean (User.class)
        registerUserBeanDefinition(app);

        /**
         * 被多个注解标记的类不会重复注册，生成的Bean只有一个。
         * eg:Config.Class 分别被 @Component和 @Import注解标记，但是只注册生成一个Bean
         *
         * 注解和API会分别注册
         * 当使用API方式注册Config.class时，和注解注册生成的不是同一个Bean
         */
        registerConfigClass(app);

        System.out.println("Config类型的所有Beans :" + app.getBeansOfType(Config.class));
        System.out.println("User类型的所有Beans :" + app.getBeansOfType(User.class));

        app.close();
    }

    public static void registerConfigClass(BeanDefinitionRegistry definitionRegistry){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Config.class);
        BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(),definitionRegistry);
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry definitionRegistry, String beanName){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder
                .addPropertyValue("id",15L)
                .addPropertyValue("name","奋发图强");
        if (StringUtils.hasText(beanName)){
            definitionRegistry.registerBeanDefinition(beanName,builder.getBeanDefinition());
        }else{
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(),definitionRegistry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry definitionRegistry){
        registerUserBeanDefinition(definitionRegistry,null);
    }


    //通过@Component方式定义
    @Component
    public static class Config{

        // 1. 通过@Bean的方式定义
        @Bean(name = {"user","dailu-user"})
        public User getUser(){
            User user = new User();
            user.setId(15L);
            user.setName("奋发图强");
            return user;
        }

    }
}
