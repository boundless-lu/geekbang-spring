package com.study.thinking.in.spring.dependency.exception;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

public class BeanCreationExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanCreationExceptionDemo.class);
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        context.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());
        context.refresh();
        context.close();
    }

    class POJO implements InitializingBean{

//        @PostConstruct
//        private void init() throws Throwable{
//            throw new Throwable("init(): For purposes");
//        }

        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("afterPropertiesSet(): For purposes");
        }
    }
}


