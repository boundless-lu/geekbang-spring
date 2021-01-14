package com.study.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author: Dailu
 * @time: 2021/1/14 21:58
 */
public class MySpringEvent extends ApplicationEvent {
    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MySpringEvent(String source) {
        super(source);
    }
}
