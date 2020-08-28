package com.study.thinking.in.spring.ioc.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * @Description: DependencySourceDemo
 * @Author Xiaoyaoyou
 * @Date: 2020/8/27 19:51
 * @Version 1.0
 */
public class DependencySourceDemo {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void init1(){
        System.out.println("beanFactory == applicationContext  "+(beanFactory == applicationContext));
        System.out.println("beanFactory == applicationContext.getBeanFactory  "+(beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("applicationContext == resourceLoader  "+(applicationContext == resourceLoader));
        System.out.println("resourceLoader == applicationEventPublisher   "+(resourceLoader == applicationEventPublisher));
    }

    @PostConstruct
    public void init2(){
        getBean(BeanFactory.class);
        getBean(ApplicationContext.class);
        getBean(ResourceLoader.class);
        getBean(ApplicationEventPublisher.class);
    }

    private <T> T getBean(Class<T> beanType){
        try{
            return beanFactory.getBean(beanType);
        }catch (NoSuchBeanDefinitionException e){
            System.err.println("当前类 "+beanType.getName()+" 无法在beanFactory中查找到！");
        }
        return null;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DependencySourceDemo.class);

        //启动应用上下文
        context.refresh();

        DependencySourceDemo demo = context.getBean(DependencySourceDemo.class);


        //关闭应用上下文
        context.close();
    }


}
