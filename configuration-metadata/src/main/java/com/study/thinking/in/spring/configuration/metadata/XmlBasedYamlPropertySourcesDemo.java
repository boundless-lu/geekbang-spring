package com.study.thinking.in.spring.configuration.metadata;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.LinkedHashMap;

/**
 * @Description: 基于 XML 资源的 YAML 外部化配置示例
 * @Author Xiaoyaoyou
 * @Date: 2020/9/18 11:24
 * @Version 1.0
 */
public class XmlBasedYamlPropertySourcesDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/yaml-sources-context.xml");
        LinkedHashMap<String,Object> bean = beanFactory.getBean("userYaml",LinkedHashMap.class);
        System.out.println(bean);
    }
}
