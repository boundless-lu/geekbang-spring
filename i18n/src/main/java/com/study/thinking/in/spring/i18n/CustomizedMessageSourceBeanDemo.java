package com.study.thinking.in.spring.i18n;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @Description:  Springboot场景下自定义  {@link MessageSource} bean
 * @Author Xiaoyaoyou
 * @Date: 2020/12/3 18:35
 * @Version 1.0
 *
 * @see MessageSource
 * @see MessageSourceAutoConfiguration
 * @see ReloadableResourceBundleMessageSource
 */

@EnableAutoConfiguration
public class CustomizedMessageSourceBeanDemo {


    /**
    * 在Springboot场景中，Primary Configuration Source(Class) 优先级高于  *AutoConfiguration
     * 所以ReloadableResourceBundleMessageSource 会覆盖 MessageSourceAutoConfiguration 中
     * springboot内置的 ResourceBundleMessageSource
    */
    @Bean
    public MessageSource messageSource(){
        return new ReloadableResourceBundleMessageSource();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(CustomizedMessageSourceBeanDemo.class)
                .web(WebApplicationType.NONE)
                .run(args);


        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        if (beanFactory.containsBean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)){

            System.out.println(beanFactory.getBeanDefinition(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME));

            MessageSource messageSource = applicationContext.getBean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME, MessageSource.class);
            System.out.println(messageSource);

        }



        applicationContext.close();
    }
}
