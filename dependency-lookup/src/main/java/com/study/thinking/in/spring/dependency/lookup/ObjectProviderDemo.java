package com.study.thinking.in.spring.dependency.lookup;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ObjectProviderDemo.class);

        context.refresh();

        lookupByProvider(context);
        lookupIfAvailable(context);
        lookupByStreamOps(context);

        context.close();
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext context) {
        ObjectProvider<String> beanProvider = context.getBeanProvider(String.class);
        Iterable<String> stringIterable = beanProvider;
//        for (String string: stringIterable){
//            System.out.println(string);
//        }
        beanProvider.stream().forEach(System.out::println);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext beanFactory){
        ObjectProvider<User> beanProvider = beanFactory.getBeanProvider(User.class);
        User user = beanProvider.getIfAvailable(User::createUser);
        System.out.println(user);

    }

    @Bean
    @Primary
    private String helloWord(){//Bean的名称不定义默认为方法名
        return "Hello Word!";
    }

    @Bean
    private String message(){//Bean的名称不定义默认为方法名
        return "Message!";
    }

    private static void lookupByProvider(AnnotationConfigApplicationContext context) {
        ObjectProvider<String> beanProvider = context.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());

        String helloWord = (String)context.getBean("helloWord");
        System.out.println(helloWord);
    }
}
