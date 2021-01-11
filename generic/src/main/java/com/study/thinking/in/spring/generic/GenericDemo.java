package com.study.thinking.in.spring.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description: GenericDemo  Java  泛型示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/11 11:07
 * @Version 1.0
 */
public class GenericDemo {

    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        //编译时类型安全校验
        //list.add(1L);

        //泛型欺骗
        Collection collection = list;
        collection.add(1L);

        //运行时 泛型擦除
        System.out.println(list);
    }
}
