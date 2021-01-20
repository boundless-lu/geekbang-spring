package com.study.thinking.in.spring.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description: EvenProfileCondition
 * @Author Xiaoyaoyou
 * @Date: 2021/1/20 17:08
 * @Version 1.0
 */
public class EvenProfileCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final Environment environment = context.getEnvironment();
        return environment.acceptsProfiles("even");
    }
}
