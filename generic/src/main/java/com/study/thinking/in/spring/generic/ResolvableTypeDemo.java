package com.study.thinking.in.spring.generic;

import org.springframework.core.ResolvableType;

/**
 * @description: {@link ResolvableType}
 * @author: Dailu
 * @time: 2021/1/13 22:55
 * @see ResolvableType
 */
public class ResolvableTypeDemo {
    public static void main(String[] args) {

        //StringList <-- ArrayList <-- AbstractList <--  List <-- Collection
        ResolvableType resolvableType = ResolvableType.forClass(StringList.class);

        Class<?> resolve = resolvableType.getSuperType().getGeneric(0).resolve();
        System.out.println(resolve);

        System.out.println(resolvableType.asCollection().resolve());
        System.out.println(resolvableType.asCollection().resolveGeneric(0));
    }
}
