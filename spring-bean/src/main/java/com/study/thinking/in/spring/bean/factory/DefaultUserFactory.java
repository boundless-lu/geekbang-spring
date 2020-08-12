package com.study.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description:
 * @author: Dailu
 * @time: 2020/5/29 17:35
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {


    @PostConstruct
    public void annotationInit(){
        System.out.println("Java注解@PostConstruct 初始化");
    }

    @PreDestroy
    public void annotationDestroy(){
        System.out.println("Java注解@PreDestroy 销毁");
    }


    public void initBean(){
        System.out.println("@Bean 注解上的 initMethod 自定义初始化");
    }

    public void destroyBean(){
        System.out.println("@Bean 注解上的 destroyMethod 自定义销毁");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBean#afterPropertiesSet()接口  初始化");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("实现DisposableBean#destroy()接口  销毁");
    }
}
