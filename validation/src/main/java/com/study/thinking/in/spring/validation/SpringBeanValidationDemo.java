package com.study.thinking.in.spring.validation;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Description: Spring Bean Validation 整合示例
 * @Date: 2020/12/8 18:03
 * @Version 1.0
 *
 * @see  Validator
 * @see LocalValidatorFactoryBean
 */
public class SpringBeanValidationDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-validation-context.xml");

//        Validator validator = applicationContext.getBean(LocalValidatorFactoryBean.class);
//        System.out.println(validator instanceof LocalValidatorFactoryBean);

        UserProcessor processor = applicationContext.getBean(UserProcessor.class);
        processor.process(new User());
        applicationContext.close();
    }

    @Component
    @Validated
    static class UserProcessor{
        public void process(@Valid User user){
            System.out.println(user);
        }
    }


    static class User{

        @NotNull
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
