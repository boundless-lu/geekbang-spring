package com.study.thinking.in.spring.ioc.dependency.injection;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

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

        System.out.println(demo.user);
        System.out.println(demo.userLazy);
        System.out.println(demo.userMap);
        System.out.println(demo.userOptional);

        //关闭应用上下文
        context.close();
    }


}
