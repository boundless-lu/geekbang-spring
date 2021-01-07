package com.study.thinking.in.spring.conversion;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: SpringCustomizedPropertyEditorDemo
 * @Author Xiaoyaoyou
 * @Date: 2020/12/17 18:57
 * @Version 1.0
 */
public class SpringCustomizedPropertyEditorDemo {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("META-INF/property-editors-context.xml");

        // AbstractApplicationContext --> "conversionService" ConversionService Bean -->
        //ConfigurableBeanFactory#setConversionService(ConversionService) -->
        //AbstractAutowireCapableBeanFactory#instatiteBean -->
        //AbstractBeanFactory#getConversionService -->
        //BeanDefinition --> BeanWrapper --> 属性转换(数据来源 PropertyValues)
        //setPropertyValues(PropertyValues) --> TypeConverter#convertIfNecessary
        //TypeConverterDelegate#convertIfNecessary  --> PropertyEditor  or  ConversionService




        final User user = context.getBean("user", User.class);

        System.out.println(user);

        // 显示地关闭 Spring 应用上下文
        context.close();

    }
}
