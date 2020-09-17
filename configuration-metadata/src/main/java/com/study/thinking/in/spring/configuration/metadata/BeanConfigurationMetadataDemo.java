package com.study.thinking.in.spring.configuration.metadata;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Description: Bean 配置元信息示例
 * @Author Xiaoyaoyou
 * @Date: 2020/9/14 17:36
 * @Version 1.0
 */
public class BeanConfigurationMetadataDemo {

    public static void main(String[] args) {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name","代璐");

        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 附加属性，不影响Bean的populate、initialize
        beanDefinition.setAttribute("name","Boundless");

        //当前BeanDefinition来自何方，辅助作用
        beanDefinition.setSource(BeanConfigurationMetadataDemo.class);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("user",beanDefinition);

        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if ("user".equals(beanName) && User.class.equals(bean.getClass())){
                    BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
                    if (BeanConfigurationMetadataDemo.class.equals(bd.getSource())){
                        String name = (String)bd.getAttribute("name");
                        User user = (User) bean;
                        user.setName(name);
                    }
                }
                return null;
            }
        });

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

    }
}
