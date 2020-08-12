package com.study.thinking.in.spring.bean.definition;

import com.study.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @description:  延迟初始化方式
 * @author: Dailu
 * @time: 2020/6/5 12:08
 */
public class BeanInitializationDemo {

//    @Autowired
//    private DefaultUserFactory defaultUserFactory;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();
        System.out.println("Application应用上下文启动。。。");

        applicationContext.getBean(DefaultUserFactory.class);
        applicationContext.close();
    }

    @Bean(initMethod = "initBean",destroyMethod = "destroyBean")
//    @Lazy
    public DefaultUserFactory  init(){
        return new DefaultUserFactory();
    }



}
