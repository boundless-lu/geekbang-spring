package com.study.thinking.in.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @Description: AnnotatedBeanDefinitionParsingDemo
 * @Author Xiaoyaoyou
 * @Date: 2020/9/3 10:00
 * @Version 1.0
 */
public class AnnotatedBeanDefinitionParsingDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
        int beforeBeanDefinitionCount = beanFactory.getBeanDefinitionCount();
        reader.register(AnnotatedBeanDefinitionParsingDemo.class);
        int afterBeanDefinitionCount = beanFactory.getBeanDefinitionCount();
        System.out.printf("注册前加载数量：%d，注册后加载数量%d,已加载数量：%d\n"
                ,beforeBeanDefinitionCount,afterBeanDefinitionCount,(afterBeanDefinitionCount-beforeBeanDefinitionCount));
        AnnotatedBeanDefinitionParsingDemo demo = beanFactory.getBean("annotatedBeanDefinitionParsingDemo", AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(demo);

    }
}
