package com.study.thinking.in.spring.ioc.bean.scope;


import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @Description: ThreadLocalScopeDemo
 * @Author Xiaoyaoyou
 * @Date: 2020/9/1 10:48
 * @Version 1.0
 */
public class ThreadLocalScopeDemo {


    @Bean
    @Scope(ThreadLocalScope.SCOPE_NAME)
    public User user() {
        return createUser();
    }

    private static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ThreadLocalScopeDemo.class);

        context.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerScope(ThreadLocalScope.SCOPE_NAME, new ThreadLocalScope());
        });

        //启动应用上下文
        context.refresh();
        customScopeInDiffThread(context);

        customScopeInSameThread(context);

        //关闭应用上下文
        context.close();
    }

    private static void customScopeInSameThread(AnnotationConfigApplicationContext context) {
        for (int i = 0; i < 3; i++) {
            System.out.println("demo.user = " + context.getBean("user", User.class));
        }
    }


    private static void customScopeInDiffThread(AnnotationConfigApplicationContext context) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                long id = Thread.currentThread().getId();
                System.out.println("[Thread id : "+id+"]---[demo.user = " + context.getBean("user", User.class));
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}