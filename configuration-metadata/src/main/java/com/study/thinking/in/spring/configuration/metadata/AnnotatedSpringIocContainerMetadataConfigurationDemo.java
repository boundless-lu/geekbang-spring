package com.study.thinking.in.spring.configuration.metadata;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * @Description: 基于Java注解的 springIOC 容器 元信息配置示例
 * @Author Xiaoyaoyou
 * @Date: 2020/9/17 16:26
 * @Version 1.0
 */

@ImportResource("META-INF/dependency-lookup-context.xml")
@Import(User.class)
@PropertySource("META-INF/user.properties")
@PropertySource("META-INF/user.properties")
public class AnnotatedSpringIocContainerMetadataConfigurationDemo {

    @Bean
    public User configuredUser(@Value("${user.id}") Long id,@Value("${user.name}")String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotatedSpringIocContainerMetadataConfigurationDemo.class);

        context.refresh();

        Map<String, User> beansOfType = context.getBeansOfType(User.class);
        for (Map.Entry<String,User> entry : beansOfType.entrySet()){
            System.out.printf("user Bean name : [%s],  context : %s \n",entry.getKey(),entry.getValue());
        }

        context.close();

    }
}
