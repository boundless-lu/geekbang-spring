package com.study.thinking.in.spring.event;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * @Description: {@link Observer} 示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/14 10:14
 * @Version 1.0
 *
 * @see Observer
 * @see Observable
 */
public class ObServerDemo {

    public static void main(String[] args) {
        EventObservable observable =new EventObservable();
        //添加观察者（监听者）
        observable.addObserver(new EventObServer());
        //发布事件
        observable.notifyObservers(new EventObject("hello World!"));
    }

    static class EventObservable extends Observable{

        public void notifyObservers(EventObject arg) {
            setChanged();
            super.notifyObservers(arg);
            clearChanged();
        }
    }

    static class EventObServer  implements Observer, EventListener {

        @Override
        public void update(Observable o, Object arg) {
            EventObject eventObject = (EventObject) arg;
            System.out.println("receive event message ："+ eventObject);
        }
    }
}
