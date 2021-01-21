package com.study.thinking.in.spring.environment;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Description: 依赖查找 {@link Environment} 示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/20 21:46
 * @Version 1.0
 * @see Environment
 */
public class LookupEnvironmentDemo implements EnvironmentAware{

    private Environment environment;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(LookupEnvironmentDemo.class);

        context.refresh();
        final LookupEnvironmentDemo contextBean = context.getBean(LookupEnvironmentDemo.class);
        Environment bean = context.getBean(ConfigurableApplicationContext.ENVIRONMENT_BEAN_NAME, Environment.class);

        System.out.println(bean);
        System.out.println(bean == contextBean.environment);


        context.close();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
