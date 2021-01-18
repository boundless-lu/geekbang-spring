package com.study.thinking.in.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * @description:
 * @author: Dailu
 * @time: 2021/1/14 21:57
 */
public class MySpringListener implements ApplicationListener<MySpringEvent> {
    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.printf("[监听线程：%s]监听到spring应用上下文事件：%s\n", Thread.currentThread().getName(), event);
    }
}
