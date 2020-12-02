package com.study.thinking.in.spring.resource;

import com.study.thinking.in.spring.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * @Description: 注入 {@link Resource} 对象示例
 * @Author Xiaoyaoyou
 * @Date: 2020/12/2 18:09
 * @Version 1.0
 * @see Resource
 * @see Value
 * @see AnnotationConfigApplicationContext
 */
public class InjectingResourceDemo {

    @Value("classpath:/META-INF/default.properties")
    private Resource resource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] resources;

    @Value("${user.dir}")
    private String currentRootPath;

    @PostConstruct
    public void init(){
        System.out.println(ResourceUtils.getContent(resource));
        System.out.println("==================================");
        System.out.println(currentRootPath);
        System.out.println("==================================");
        Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingResourceDemo.class);
        context.refresh();
        context.close();
    }
}
