package com.study.thinking.in.spring.ioc.bean.scope;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/**
 * @description:
 * @author: Dailu
 * @time: 2020/8/30 18:03
 */
public class BeanScopeDemo implements DisposableBean {

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser2;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser3;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser3;

    @Autowired
    private Map<String,User> userMap;

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;  //Resolvable Dependency


    @Bean
    //Scope 默认为单例模式
    public User singletonUser(){
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User prototypeUser(){
        return createUser();
    }

    private static User createUser(){
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }


    //结论一：
    //singleton Bean  无论是依赖查找还是依赖注入  均为同一个对象
    //prototype Bean  无论是依赖查找还是依赖注入  均为新生成的对象


    //结论二：
    //依赖注入集合类型对象时，singleton Bean 和 prototype Bean 各存在一个。
    //依赖注入集合类型对象时，singleton Bean 同其它地方依赖注入的 singleton Bean 是同一个对象。
    //依赖注入集合类型对象时，prototype Bean 同其它地方依赖注入的 prototype Bean 不同，是新生成的对象。


    //结论三：
    //无论时singleton Bean 还是 prototype Bean 都会执行初始化方法回调
    //不过仅有singleton Bean 会执行销毁方法回调

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanScopeDemo.class);


        context.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("%s Bean Name : %s 初始化后回调。。。\n",bean.getClass().getName(),beanName);
                    return bean;
                }
            });
        });




        //启动应用上下文
        context.refresh();

        getBeansByLookup(context);

        getBeansByInjection(context);

        //关闭应用上下文
        context.close();
    }

    private static void getBeansByInjection(AnnotationConfigApplicationContext context) {
        BeanScopeDemo demo = context.getBean(BeanScopeDemo.class);
        System.out.println("demo.singletonUser1 = "+ demo.singletonUser1);
        System.out.println("demo.singletonUser2 = "+ demo.singletonUser2);
        System.out.println("demo.singletonUser3 = "+ demo.singletonUser3);
        System.out.println("demo.prototypeUser1 = "+ demo.prototypeUser1);
        System.out.println("demo.prototypeUser2 = "+ demo.prototypeUser2);
        System.out.println("demo.prototypeUser3 = "+ demo.prototypeUser3);
        //集合类型
        System.out.println("demo.userMap = "+ demo.userMap);

    }

    private static void getBeansByLookup(AnnotationConfigApplicationContext context) {
        for (int i= 0;i< 3; i++){
            System.out.println("demo.singletonUser = "+ context.getBean("singletonUser",User.class));
            System.out.println("demo.prototypeUser = "+ context.getBean("prototypeUser",User.class));
        }
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("当前 BeanScopeDemo 正在销毁中。。。");
        this.prototypeUser1.destroy();
        this.prototypeUser2.destroy();
        this.prototypeUser3.destroy();
        this.userMap.entrySet().forEach(o->{
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(o.getKey());
            if (beanDefinition.isPrototype()){
                o.getValue().destroy();
            }
        });

        System.out.println("当前 BeanScopeDemo 销毁完毕。。。");
    }
}

