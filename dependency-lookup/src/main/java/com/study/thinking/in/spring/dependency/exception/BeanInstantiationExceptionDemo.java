package com.study.thinking.in.spring.dependency.exception;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInstantiationExceptionDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanInstantiationExceptionDemo.class);

        //注册BeanDefinition，Bean Class 是一个接口
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);
        context.registerBeanDefinition("errorBean",beanDefinitionBuilder.getBeanDefinition());

        context.refresh();
        context.close();
    }


}
