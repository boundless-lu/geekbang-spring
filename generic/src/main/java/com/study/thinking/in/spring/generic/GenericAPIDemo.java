package com.study.thinking.in.spring.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @Description: GenericAPIDemo
 * @Author Xiaoyaoyou
 * @Date: 2021/1/11 11:29
 * @Version 1.0
 * @see Type
 */
public class GenericAPIDemo {

    public static void main(String[] args) {

        //原生类型 primitive types: int,long
        Class intClass = int.class;

        //数组类型 array types:  int[], object[]
        Class objectArrayClass = Object[].class;

        //原始类型  raw types:  java.lang.String
        Class rawClass = String.class;


        //泛型参数类型  parameterized types：
        ParameterizedType parameterizedType = (ParameterizedType) ArrayList.class.getGenericSuperclass();
        //parameterizedType.getRawType() ==>java.util.AbstractList
        System.out.println(parameterizedType);

        //泛型类型变量  type variables:
        Stream.of(parameterizedType.getActualTypeArguments()).map(TypeVariable.class::cast).forEach(System.out::println);

    }
}
