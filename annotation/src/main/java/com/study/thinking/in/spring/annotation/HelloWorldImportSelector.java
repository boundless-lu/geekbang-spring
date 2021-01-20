package com.study.thinking.in.spring.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description: HelloWorld 注解  {@link ImportSelector} 实现示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/20 15:32
 * @Version 1.0
 * @see ImportSelector
 */
public class HelloWorldImportSelector  implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.study.thinking.in.spring.annotation.HelloWorldConfiguration"};
    }
}
