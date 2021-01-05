package com.study.thinking.in.spring.conversion;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Description:  {@link Properties} -->  {@link String}  {@link ConditionalGenericConverter} 实现
 * @Author Xiaoyaoyou
 * @Date: 2021/1/5 16:28
 * @Version 1.0
 * @see Properties
 * @see ConditionalGenericConverter
 */
public class PropertiesToStringConverter implements ConditionalGenericConverter {
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return (Properties.class.equals(sourceType.getObjectType())
                && String.class.equals(targetType.getObjectType()));
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(Properties.class,String.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Properties properties = (Properties) source;

        StringBuilder textBuilder = new StringBuilder();

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
//            textBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(System.getProperty("line.separator"));
            textBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(";");
        }

        return textBuilder.toString();
    }
}
