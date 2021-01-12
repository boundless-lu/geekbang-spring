package com.study.thinking.in.spring.generic;

import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:  {@link GenericTypeResolver}
 * @author: Dailu
 * @time: 2021/1/12 21:15
 * @see GenericTypeResolver
 */
public class GenericTypeResolverDemo {

    public static void main(String[] args) throws NoSuchMethodException {

        //String是Comparable<String>泛型参数类型的具体化
        display(GenericTypeResolverDemo.class,Comparable.class,"getString");
        display(GenericTypeResolverDemo.class,List.class,"getList");
        // List<Object>是List泛型参数类型的具体化
        display(GenericTypeResolverDemo.class,List.class,"getList",String.class);
        // ArrayList<String>是List泛型参数类型的具体化
        display(GenericTypeResolverDemo.class,List.class,"getStringList");

        //TypeVariable
        Map<TypeVariable, Type> typeVariableMap = GenericTypeResolver.getTypeVariableMap(StringList.class);
        System.out.println(typeVariableMap);
    }

    public static String getString() {
        return null;
    }

    public static <E> List<E> getList(){ //泛型参数没有具体化（字节码无记录）
        return null;
    }

    public static List<Object> getList(String arg){ //泛型参数具体化（字节码有记录）
        return null;
    }

    public static StringList getStringList(){
        return null;
    }

    static class StringList extends ArrayList<String>{//泛型参数具体化（字节码有记录）

    }

    public static void display(Class<?> containingClass,Class<?> genericIfc,String methodName,Class... argumentsType) throws NoSuchMethodException {
        Method method = containingClass.getMethod(methodName,argumentsType);

        //常规类作为方法返回值
        Class<?> returnType = GenericTypeResolver.resolveReturnType(method, containingClass);
        System.out.printf("GenericTypeResolver.resolveReturnType(%s,%s) = %s\n",methodName,containingClass.getSimpleName(),returnType);


        //常规类型不具备泛型参数类型
        Class<?> returnTypeArguments = GenericTypeResolver.resolveReturnTypeArgument(method, genericIfc);
        System.out.printf("GenericTypeResolver.resolveReturnTypeArgument(%s,%s) = %s\n",methodName,containingClass.getSimpleName(),returnTypeArguments);

        System.out.println("====================================");
    }

}
