package com.study.thinking.in.spring.annotation;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan
public @interface MyComponentScan1 {

    @AliasFor(annotation = ComponentScan.class,attribute = "basePackages")
    String[] myComponentScan1Packages() default {};

}
