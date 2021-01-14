package com.study.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description: spring 层次性事件传播
 * @author: Dailu
 * @time: 2021/1/14 20:54
 */
public class HierarchicalApplicationEventDemo {

    public static void main(String[] args) {
        //1.创建 parent spring 应用上下文
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.setId("parent-context");
        //注册MyListener 到 parent spring 应用上下文
        parentContext.register(MyApplicationListener.class);

        //2.创建 current spring 应用上下文
        AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();
        currentContext.setId("current-context");
        //注册MyListener 到 current spring 应用上下文
        currentContext.register(MyApplicationListener.class);

        //3. current --> parent
        currentContext.setParent(parentContext);

        //4.启动应用上下文
        parentContext.refresh();
        currentContext.refresh();

        //5.
        currentContext.close();
        parentContext.close();
    }

    static class MyApplicationListener implements ApplicationListener<ApplicationContextEvent> {

        //解决层次性传递中重复传递的问题，可以使用过滤
        private static Set<ApplicationContextEvent> processed = new LinkedHashSet<>();

        @Override
        public void onApplicationEvent(ApplicationContextEvent event) {
            if (processed.add(event)) {
                System.out.printf("监听到spring应用上下文[%s]的事件：%s\n", event.getApplicationContext().getId(), event.getClass().getSimpleName());
            }
        }
    }
}
