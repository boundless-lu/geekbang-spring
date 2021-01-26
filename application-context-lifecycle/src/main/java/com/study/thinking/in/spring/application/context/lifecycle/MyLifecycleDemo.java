package com.study.thinking.in.spring.application.context.lifecycle;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @description: 自定义 {@link Lifecycle} bean 示例
 * @author: Dailu
 * @time: 2021/1/26 21:37
 */
public class MyLifecycleDemo {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        context.registerBeanDefinition("MyLifecycle",
                BeanDefinitionBuilder.genericBeanDefinition(MyLifecycle.class).getBeanDefinition());

        context.refresh();

        context.start();

        context.stop();


        context.close();

    }
}
