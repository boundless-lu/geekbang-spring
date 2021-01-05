package com.study.thinking.in.spring.data.binding;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: {@link DataBinder} 示例
 * @Author Xiaoyaoyou
 * @Date: 2020/12/15 16:06
 * @Version 1.0
 */
public class DataBinderDemo {

    public static void main(String[] args) {
        //1.创建空对象
        User user = new User();

        //2.创建DataBinder
        DataBinder dataBinder = new DataBinder(user);

        //3.创建 PropertyValues，设置属性
        Map<String, Object> propertyValues = new HashMap<>();
            propertyValues.put("id", 18);
            propertyValues.put("name", "逍遥游");
            //a.存在user中没有的属性。DataBinder会忽略未知属性
            propertyValues.put("age", 18);

            //b.user中有嵌套属性。DataBinder支持嵌套属性
            propertyValues.put("company.name", "清风明月");

        PropertyValues source = new MutablePropertyValues(propertyValues);

            //是否忽略不存在的绑定字段，true（默认）--》false
//            dataBinder.setIgnoreUnknownFields(false);

            //是否忽略无效的绑定字段，false（默认）--》true，需要和setAutoGrowNestedPaths配合使用
//            dataBinder.setIgnoreInvalidFields(true);
            //是否支持嵌套路径自动增长  true（默认）--》false
//            dataBinder.setAutoGrowNestedPaths(false);

        //设置必须属性
        dataBinder.setRequiredFields("id","name","city");

        //4.绑定属性
        dataBinder.bind(source);

        //5.输出绑定对象
        System.out.println(user);

        //6.输出绑定结果
        BindingResult result = dataBinder.getBindingResult();
        System.out.println(result);
    }
}
