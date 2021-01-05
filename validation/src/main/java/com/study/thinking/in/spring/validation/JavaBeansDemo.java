package com.study.thinking.in.spring.validation;

import com.study.thinking.in.spring.ioc.overview.domain.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @Description: JavaBeans 示例
 * @Author Xiaoyaoyou
 * @Date: 2020/12/16 16:40
 * @Version 1.0
 */
public class JavaBeansDemo {

    public static void main(String[] args) throws IntrospectionException {

        //第二个参数为排除（截止）类
        final BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);

        //propertyDescriptor 属性描述
        //所有Java类均继承自 java.lang.Object
        //class 属性来自 java.lang.Object#getClass()方法，可以被排除
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> System.out.println(propertyDescriptor));
        System.out.println("=========================================================");

        //methodDescriptor 方法描述
        Stream.of(beanInfo.getMethodDescriptors()).forEach(System.out::println);
    }
}
