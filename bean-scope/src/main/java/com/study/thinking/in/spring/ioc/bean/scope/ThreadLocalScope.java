package com.study.thinking.in.spring.ioc.bean.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 自定义Scope {@link ThreadLocalScope}
 * @Author Xiaoyaoyou
 * @Date: 2020/9/1 10:28
 * @Version 1.0
 */
public class ThreadLocalScope implements Scope {

    public static final String SCOPE_NAME = "thread-local-scope";

    private NamedThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal<Map<String, Object>>("thread-local") {
        @Override
        public Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    private Map<String, Object> getContext() {
        return threadLocal.get();
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getContext();
        Object object = context.get(name);
        if (object == null) {
            object = objectFactory.getObject();
            context.put(name, object);
        }
        return object;
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> context = getContext();
        return context.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        //TODO
    }

    @Override
    public Object resolveContextualObject(String key) {
        Map<String, Object> context = getContext();
        return context.get(key);
    }

    @Override
    public String getConversationId() {
        Thread t = Thread.currentThread();
        return String.valueOf(t.getId());
    }
}
