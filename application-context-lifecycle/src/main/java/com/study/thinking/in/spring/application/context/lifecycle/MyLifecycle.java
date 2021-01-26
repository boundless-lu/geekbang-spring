package com.study.thinking.in.spring.application.context.lifecycle;

import org.springframework.context.Lifecycle;

/**
 * @description: 自定义 {@link Lifecycle}
 * @author: Dailu
 * @time: 2021/1/26 21:12
 * @see Lifecycle
 */
public class MyLifecycle  implements Lifecycle{

    private boolean running = Boolean.FALSE;

    @Override
    public void start() {
        running = Boolean.TRUE;
        System.out.println("MyLifecycle 启动。。。");
    }

    @Override
    public void stop() {
        running = Boolean.FALSE;
        System.out.println("MyLifecycle 停止。。。");
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
