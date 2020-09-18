package com.study.thinking.in.spring.configuration.metadata;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description: YamlPropertySourceFactory
 * @Author Xiaoyaoyou
 * @Date: 2020/9/18 17:05
 * @Version 1.0
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String s, EncodedResource encodedResource) throws IOException {
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(encodedResource.getResource());
        Properties yamlProperties = yamlPropertiesFactoryBean.getObject();
        return new PropertiesPropertySource(s,yamlProperties);
    }
}
