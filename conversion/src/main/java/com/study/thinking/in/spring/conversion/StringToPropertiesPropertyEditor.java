package com.study.thinking.in.spring.conversion;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * @Description: String -->  Properties  类型转换
 * @Author Xiaoyaoyou
 * @Date: 2020/12/17 11:06
 * @Version 1.0
 */
public class StringToPropertiesPropertyEditor extends PropertyEditorSupport {


    // 1. 实现 setAsText(String) 方法
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // 2. 将 String 类型转换成 Properties 类型
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(text));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        if (text.contains("=")){
            // 3. 临时存储 Properties 对象
            setValue(properties);
        }


        // next 获取临时 Properties 对象 #getValue();
    }

    @Override
    public String getAsText() {
        Properties properties = (Properties) getValue();

        StringBuilder textBuilder = new StringBuilder();

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            textBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(System.getProperty("line.separator"));
        }

        return textBuilder.toString();
    }

}
