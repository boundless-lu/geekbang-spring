package com.study.thinking.in.spring.dependency.lookup;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: 类型安全的依赖查找示例
 * @author: Dailu
 * @time: 2020/6/27 16:41
 */
public class TypeSafetyDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(TypeSafetyDependencyLookupDemo.class);

        context.refresh();
        //演示BeanFactory#getBean 方法的安全性
        displayBeanFactoryGetBean(context);
        //演示ObjectFactory#getObject 方法的安全性
        displayObjectFactoryGetObject(context);
        //演示ObjectProvider#getIfAvailable 方法的安全性
        displayObjectProviderGetIfAvailable(context);
        //演示ListableBeanFactory#getBeansOfType 方法的安全性
        displayListableBeanFactoryGetBeansOfType(context);
        //演示ObjectProvider#Stream 方法的安全性
        displayObjectProviderStreamOps(context);

        context.close();
    }

    private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext context) {
        ObjectProvider<User> beanProvider = context.getBeanProvider(User.class);
        printBeansException("displayObjectProviderStreamOps",()->beanProvider.forEach(System.out::println));
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory context) {
        printBeansException("displayListableBeanFactoryGetBeansOfType",()->context.getBeansOfType(User.class));
    }

    private static void displayObjectProviderGetIfAvailable(AnnotationConfigApplicationContext context) {
        ObjectProvider<User> beanProvider = context.getBeanProvider(User.class);
        printBeansException("displayObjectProviderGetIfAvailable",()->{
            User user = beanProvider.getIfAvailable();
        });
    }

    private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext context) {
        ObjectProvider<User> beanProvider = context.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject",()->{
            User user = beanProvider.getObject();
        });
    }

    private static void displayBeanFactoryGetBean(AnnotationConfigApplicationContext context) {
        printBeansException("displayBeanFactoryGetBean",()->{
            User bean = context.getBean(User.class);
        });
    }

    private static void printBeansException(String source,Runnable runnable){
        System.out.println("==================================================");
        System.out.println("Source from:"+source);
        try{
            runnable.run();
        }catch(BeansException exception){
            exception.printStackTrace();
        }

    }
}
