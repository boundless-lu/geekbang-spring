package com.study.thinking.in.spring.environment;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Description: 依赖注入 {@link Environment} 示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/20 21:46
 * @Version 1.0
 * @see Environment
 */
public class InjectingEnvironmentDemo implements EnvironmentAware, ApplicationContextAware {

    private Environment environment;

    @Autowired
    private Environment autoEnvironment;


    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationContext autoApplicationContext;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(InjectingEnvironmentDemo.class);

        context.refresh();

        final InjectingEnvironmentDemo bean = context.getBean(InjectingEnvironmentDemo.class);
        System.out.println(bean.environment);
        System.out.println(bean.environment == bean.autoEnvironment);
        System.out.println(bean.environment == context.getEnvironment());

        System.out.println(bean.environment == bean.autoApplicationContext.getEnvironment());
        System.out.println(bean.applicationContext == bean.autoApplicationContext);
        System.out.println(bean.applicationContext == context);

        context.close();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
