package com.study.thinking.in.spring.ioc.dependency.injection;

import com.study.thinking.in.spring.ioc.dependency.injection.annotation.InjectUser;
import com.study.thinking.in.spring.ioc.dependency.injection.annotation.MyAutowired;
import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;
import static org.springframework.context.annotation.AnnotationConfigUtils.CONFIGURATION_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * @Description: 注解驱动的依赖注入处理过程---(入口方法)--->DefaultListableBeanFactory.resolveDependency()
 * @Author Xiaoyaoyou
 * @Date: 2020/8/25 10:06
 * @Version 1.0
 */
public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired          //通过类型依赖查找(处理)
    private User user;  //DependencyDescriptor->
                        //必须(required=true)
                        //实时注入(eager=true)
                        //通过类型(User.class)
                        //字段名称('user')
                        //是否首要(primary=true)

    @Autowired
    @Lazy
    private User userLazy; //延迟加载

    @Autowired
    private Map<String,User> userMap;//集合类型依赖注入

    @Autowired
    private Optional<User> userOptional;

    @MyAutowired
    private Optional<User> myAutowiredUser;

    @InjectUser
    private Optional<User> injectUser;


    /**
    * 一下方法通过扩展AutowiredAnnotationBeanPostProcessor类的形式，增加自定义的依赖注入注解
     * 如果Bean Name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME
     * 则扩展的bean会替换原始的bean，否则相当于新增加一个AutowiredAnnotationBeanPostProcessor
     *
     * 其中static是关键，不加这个静态关键字，两种方式都不生效。
    */

//    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    private static AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor(){
//        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
//        Set<Class<? extends Annotation>> autowiredTypes = new LinkedHashSet<>(asList(Autowired.class,Inject.class,InjectUser.class));
//        processor.setAutowiredAnnotationTypes(autowiredTypes);
//        return  processor;
//    }

    @Bean
//    @Order(Ordered.LOWEST_PRECEDENCE - 2)
    private static AutowiredAnnotationBeanPostProcessor beanPostProcessor(){
        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
        processor.setAutowiredAnnotationType(InjectUser.class);
        return  processor;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationDependencyInjectionResolutionDemo.class);

        //设置Bean注册中心
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String path = "META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(path);

        //启动应用上下文
        context.refresh();

        AnnotationDependencyInjectionResolutionDemo demo = context.getBean(AnnotationDependencyInjectionResolutionDemo.class);

        System.out.println("user:"+demo.user);
        System.out.println("userLazy:"+demo.userLazy);
        System.out.println("userMap:"+demo.userMap);
        System.out.println("userOptional:"+demo.userOptional);
        System.out.println("myAutowiredUser:"+demo.myAutowiredUser);
        System.out.println("injectUser:"+demo.injectUser);

        //关闭应用上下文
        context.close();
    }


}
