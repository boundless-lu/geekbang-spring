package com.study.thinking.in.spring.bean.lifecycle;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description: UserHolder
 * @Author Xiaoyaoyou
 * @Date: 2020/9/8 11:26
 * @Version 1.0
 */
public class UserHolder implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
        EnvironmentAware, InitializingBean, SmartInitializingSingleton, DisposableBean {

    private final User user;

    private Integer number;

    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public UserHolder(User user) {
        this.user = user;
    }

    @PostConstruct
    public void postConstructInit() {
        this.setDescription("This is user holder V4!");
        System.out.println("postConstructInit() = " + this.description);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setDescription("This is user holder V5!");
        System.out.println("afterPropertiesSet() = " + this.description);
    }

    public void customInit(){
        this.setDescription("This is user holder V6!");
        System.out.println("customInit() = " + this.description);
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.setDescription("This is user holder V8!");
        System.out.println("afterSingletonsInstantiated() = " + this.description);
    }

    @PreDestroy
    public void preDestroy(){
        this.setDescription("This is user holder V10!");
        System.out.println("preDestroy() = " + this.description);
    }

    @Override
    public void destroy() throws Exception {
        this.setDescription("This is user holder V11!");
        System.out.println("destroy() = " + this.description);
    }

    public void doDestroy(){
        this.setDescription("This is user holder V12!");
        System.out.println("doDestroy() = " + this.description);
    }

    protected void finalize() throws Throwable {
        System.out.println("finalize() 方法被调用！ ");
    }



    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment");
    }

}
