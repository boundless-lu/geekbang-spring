package com.study.thinking.in.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: spring Multicaster异步事件处理
 * @author: Dailu
 * @time: 2021/1/14 21:54
 */
public class AsyncEventHandlerDemo {

    public static void main(String[] args) {

        GenericApplicationContext context = new GenericApplicationContext();

        //1.添加自定义spring事件监听器
        context.addApplicationListener(new MySpringListener());

        //2.启动spring应用上下文
        context.refresh();//初始化 ApplicationEventMulticaster

        //依赖查找 ApplicationEventMulticaster
        ApplicationEventMulticaster applicationEventMulticaster =
                context.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);

        if (applicationEventMulticaster instanceof SimpleApplicationEventMulticaster){
            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster =
                    (SimpleApplicationEventMulticaster) applicationEventMulticaster;

            //切换taskExecutor
            ExecutorService taskService = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("Listener-thread-pool"));
            simpleApplicationEventMulticaster.setTaskExecutor(taskService);

            //添加ContextClosedEvent事件处理，优雅下线
            simpleApplicationEventMulticaster.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
                @Override
                public void onApplicationEvent(ContextClosedEvent event) {
                    if (! taskService.isShutdown()){
                        taskService.shutdown();
                    }
                }
            });
        }
        //3.发布自定义spring事件
        context.publishEvent(new MySpringEvent("Hello SimpleApplicationEventMulticaster!"));

        //4.关闭spring应用上下文
        context.close();
    }
}
