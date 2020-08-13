package com.study.thinking.in.spring.ioc.dependency.injection;



import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: 基于API的依赖 Constructor 注入示例
 * @Author Xiaoyaoyou
 * @Date: 2020/8/6 17:44
 * @Version 1.0
 */
public class ApiDependencyConstructorInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        BeanDefinition userHolderDefinition = createUserHolderBeanDefinition();
        context.registerBeanDefinition("userHolder",userHolderDefinition);


        //设置Bean注册中心
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("META-INF/dependency-lookup-context.xml");

        //启动应用上下文
        context.refresh();

        UserHolder bean = context.getBean(UserHolder.class);
        System.out.println(bean);

        //关闭应用上下文
        context.close();
    }

    private static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        builder.addConstructorArgReference("superUser");
        return builder.getBeanDefinition();
    }
}
