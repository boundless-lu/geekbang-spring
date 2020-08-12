package com.study.thinking.in.spring.dependency.exception;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class NoUniqueBeanDefinitionExceptionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(NoUniqueBeanDefinitionExceptionDemo.class);
        context.refresh();

        try{
            context.getBean(String.class);
        }catch(NoUniqueBeanDefinitionException e){
            System.err.printf("finding %d beans, type is %s, message: %s",
                    e.getNumberOfBeansFound(),String.class.getTypeName(),e.getMessage());
        }
        context.close();
    }

    @Bean
    private String bean1(){
        return "1";
    }

    @Bean
    private String bean2(){
        return "2";
    }

    @Bean
    private String bean3(){
        return "3";
    }

}
