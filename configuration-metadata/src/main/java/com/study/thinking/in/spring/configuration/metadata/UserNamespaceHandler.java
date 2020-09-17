package com.study.thinking.in.spring.configuration.metadata;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Description: UsersNamespaceHandler
 * @Author Xiaoyaoyou
 * @Date: 2020/9/17 18:44
 * @Version 1.0
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        //注册user元素对应的BeanDefinitionParser实现
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
