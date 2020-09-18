package com.study.thinking.in.spring.configuration.metadata;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 外部化配置示例
 * @Author Xiaoyaoyou
 * @Date: 2020/9/18 10:18
 * @Version 1.0
 */

@PropertySource("META-INF/user.properties")
public class PropertySourcesDemo {

    @Bean
    public User user(@Value("${user.id}") Long id, @Value("${user.name}")String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PropertySourcesDemo.class);

        //扩展Environment中的PropertySources
        //添加PropertySources 操作必须在 refresh方法 之前完成
        Map<String,Object> property = new HashMap<>();
        property.put("user.name","dailu");
        org.springframework.core.env.PropertySource propertySource = new MapPropertySource("first-property-sources",property);
        context.getEnvironment().getPropertySources().addFirst(propertySource);

        context.refresh();

        Map<String, User> beansOfType = context.getBeansOfType(User.class);
        for (Map.Entry<String,User> entry : beansOfType.entrySet()){
            System.out.printf("user Bean name : [%s],  context : %s \n",entry.getKey(),entry.getValue());
        }
        System.out.println(context.getEnvironment().getPropertySources());
        context.close();

    }
}
