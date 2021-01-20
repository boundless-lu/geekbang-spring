package com.study.thinking.in.spring.annotation;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description: HelloWorld 注解实现 {@link ImportBeanDefinitionRegistrar} 示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/20 15:57
 * @Version 1.0
 * @see  ImportBeanDefinitionRegistrar
 */
public class HelloWorldImportBeanDefinitionRegistrar  implements ImportBeanDefinitionRegistrar{

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        AnnotatedGenericBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(HelloWorldConfiguration.class);
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition,registry);
    }
}
