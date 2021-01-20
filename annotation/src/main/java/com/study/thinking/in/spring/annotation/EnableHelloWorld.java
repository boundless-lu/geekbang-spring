package com.study.thinking.in.spring.annotation;


import org.springframework.context.annotation.Import;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Description: 激活HelloWorld 模块注解
* @Author: CMCC
* @Date: 2021/1/20
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented

//第二步：通过@Import注解导入具体实现
//@Import(HelloWorldConfiguration.class)  //方法一：通过Configuration class 实现

//@Import(HelloWorldImportSelector.class)  //方法二：通过ImportSelector接口实现
@Import(HelloWorldImportBeanDefinitionRegistrar.class)  //方法三：通过ImportBeanDefinitionRegistrar接口实现
public @interface EnableHelloWorld { //第一步：通过EnableXXX  命名
}
