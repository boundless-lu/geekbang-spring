package com.study.thinking.in.spring.resource;

import com.study.thinking.in.spring.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * @Description: 注入 {@link ResourceLoader} 对象示例
 * @Author Xiaoyaoyou
 * @Date: 2020/12/2 18:09
 * @Version 1.0
 * @see ResourceLoader
 * @see Value
 * @see AnnotationConfigApplicationContext
 */
public class InjectingResourceLoaderDemo implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;  //方法一

    @Autowired
    private ResourceLoader autowiredResourceLoader; //方法二

    @Autowired
    private AbstractApplicationContext context; //方法三

    @PostConstruct
    public void init(){
        System.out.println("resourceLoader == autowiredResourceLoader :"+(resourceLoader == autowiredResourceLoader));
        System.out.println("resourceLoader == context :"+(resourceLoader == context));
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingResourceLoaderDemo.class);
        context.refresh();
        context.close();
    }
}
