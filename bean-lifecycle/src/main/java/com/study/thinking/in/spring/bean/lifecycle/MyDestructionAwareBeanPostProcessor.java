package com.study.thinking.in.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @Description: MyDestructionAwareBeanPostProcessor
 * @Author Xiaoyaoyou
 * @Date: 2020/9/10 16:16
 * @Version 1.0
 */
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("This is user holder V9!");
            System.out.println("postProcessBeforeDestruction() = " + userHolder.getDescription());
        }
    }
}
