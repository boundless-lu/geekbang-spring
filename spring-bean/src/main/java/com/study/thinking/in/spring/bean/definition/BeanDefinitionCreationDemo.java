package com.study.thinking.in.spring.bean.definition;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        //1.通过BeanDefinitionBuilder 构建
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //设置属性
        builder
                .addPropertyValue("id",1)
                .addPropertyValue("name","dailu");
        //获取BeanDefinition实例，并非是Bean的最终形态，可以自定义修改
        BeanDefinition beanDefinition = builder.getBeanDefinition();

        //2.通过AbstractBeanDefinition及其派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置 Bean类型
        genericBeanDefinition.setBeanClass(User.class);

        //通过MutablePropertyValues批量设置属性
        MutablePropertyValues values = new MutablePropertyValues();
        values.add("id",1).add("name","dailu");
        genericBeanDefinition.setPropertyValues(values);

    }
}
