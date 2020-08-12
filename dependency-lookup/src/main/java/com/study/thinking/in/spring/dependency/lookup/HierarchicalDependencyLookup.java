package com.study.thinking.in.spring.dependency.lookup;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * @description: 层次性依赖查找
 * @author: Dailu
 * @time: 2020/6/23 21:01
 */
public class HierarchicalDependencyLookup {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ObjectProviderDemo.class);
//        context.refresh();

        //获取hierarchicalBeanFactory --> ConfigurableBeanFactory --> ConfigurableListableBanFactory
        ConfigurableListableBeanFactory factory = context.getBeanFactory();
        HierarchicalBeanFactory parentBeanFactory = createBeanFactory();
        //设置当前Bean的父亲BeanFactory
        factory.setParentBeanFactory(parentBeanFactory);
//        displayContainsLocalBean(factory,"user");
//        displayContainsLocalBean(parentBeanFactory,"user");

        displayContainsBean(factory,"user");
        displayContainsBean(parentBeanFactory,"user");
        context.close();
    }


    private static void displayContainsBean(HierarchicalBeanFactory factory,String beanName){
        System.out.printf("当前bean[%s]是否包含Bean[%s]--存在:[%s]\n",factory,beanName,containsBean(factory,beanName));

    }

    private static boolean containsBean(HierarchicalBeanFactory factory,String beanName){
        BeanFactory parentBeanFactory = factory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory cast = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if (containsBean(cast,beanName)){
                return true;
            }
        }
        return factory.containsLocalBean(beanName);
    }

    private static void displayContainsLocalBean(HierarchicalBeanFactory factory,String beanName){
        System.out.printf("当前bean[%s]是否包含Localbean[%s]--存在:[%s]\n",factory,beanName,factory.containsLocalBean(beanName));
    }


    private static HierarchicalBeanFactory createBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(location);
        return beanFactory;
    }

}
