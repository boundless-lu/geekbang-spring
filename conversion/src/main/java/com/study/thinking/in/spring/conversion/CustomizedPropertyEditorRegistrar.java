package com.study.thinking.in.spring.conversion;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.util.Properties;

/**
 * @Description: 自定义 {@link PropertyEditorRegistrar}  实现
 * @Author Xiaoyaoyou
 * @Date: 2020/12/17 18:44
 * @Version 1.0
 */
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(User.class,"context",new StringToPropertiesPropertyEditor());
    }
}
