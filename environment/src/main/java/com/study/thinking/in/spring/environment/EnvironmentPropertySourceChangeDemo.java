package com.study.thinking.in.spring.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: {@link Environment} 配置属性源变更示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/22 15:18
 * @Version 1.0
 * @see Environment
 */

public class EnvironmentPropertySourceChangeDemo {

    @Value("${user.name}") //spring应用上下文启动后，不具备动态更新能力
    private String userName;


    //PropertySource[name = first-property-source]-->'user.name' = 逍遥游
    //PropertySource[name = systemProperties]-->'user.name' = EDZ
    //PropertySource[name = systemEnvironment]-->'user.name' = null
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(EnvironmentPropertySourceChangeDemo.class);

        //在 spring应用上下文 启动前，调整Environment中的PropertySource
        ConfigurableEnvironment environment = context.getEnvironment();
        //获取MutablePropertySources 对象
        MutablePropertySources propertySources = environment.getPropertySources();
        //动态插入PropertySource 到 MutablePropertySources 中
        Map<String,Object> map = new HashMap<>();
        map.put("user.name","逍遥游");
        MapPropertySource propertySource = new MapPropertySource("first-property-source",map);
        propertySources.addFirst(propertySource);

        // 启动spring应用上下文
        context.refresh();
        
        //spring应用上下文启动后,更新propertySource中的属性值，但是无法影响到@Value了。
        map.put("user.name","007");

        EnvironmentPropertySourceChangeDemo bean = context.getBean(EnvironmentPropertySourceChangeDemo.class);
        System.out.println(bean.userName);

        for (PropertySource ps : propertySources){
            System.out.printf("PropertySource[name = %s]-->'user.name' = %s\n",ps.getName(),ps.getProperty("user.name"));
        }
        context.close();
    }
}
