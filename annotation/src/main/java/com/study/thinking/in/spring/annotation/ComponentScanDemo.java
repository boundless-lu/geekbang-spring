package com.study.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Description: {@link Component} 扫描示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/19 19:49
 * @Version 1.0
 * @see Component
 * @see ComponentScan
 */

// @ComponentScan中的@AliasFor("basePackages")和@AliasFor("value")互为显性别名
@ComponentScan(basePackages = "com.study.thinking.in.spring.annotation")

// @MyComponentScan1中的@AliasFor(annotation = ComponentScan.class,attribute = "basePackages")
// 为@ComponentScan中basePackages属性的隐性别名【‘子’注解属性引用‘父(元)’注解属性，类似于多态】
@MyComponentScan1(myComponentScan1Packages = "com.study.thinking.in.spring.annotation")

// @MyComponentScan2中的@AliasFor(annotation = MyComponentScan1.class,attribute = "myComponentScan1Packages")
// 为MyComponentScan1中myComponentScan1Packages属性的隐性别名【‘子’注解属性引用‘父(元)’注解属性，类似于多态】
// 实现隐形别名的传递性
@MyComponentScan2(myComponentScan2Packages = "com.study.thinking.in.spring.annotation")


//注解的隐性覆盖：子注解中和‘父(元)’注解属性同名的属性，会直接覆盖‘父(元)’注解属性
//注解的显性覆盖：子注解中标注 @AliasFor‘父(元)’注解属性， 会覆盖‘父(元)’注解属性
public class ComponentScanDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册 configuration class
        context.register(ComponentScanDemo.class);

        //启动spring应用上下文
        context.refresh();

        final TestClass bean = context.getBean(TestClass.class);
        System.out.println(bean);

        //关闭spring应用上下文
        context.close();

    }
}
