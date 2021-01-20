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
@MyComponentScan1
public @interface MyComponentScan2 {

    @AliasFor(annotation = MyComponentScan1.class,attribute = "myComponentScan1Packages")
    String[] myComponentScan2Packages() default {};

}
