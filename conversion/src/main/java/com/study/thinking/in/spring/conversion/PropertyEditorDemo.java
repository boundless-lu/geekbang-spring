package com.study.thinking.in.spring.conversion;

import java.beans.PropertyEditor;

/**
 * @Description:  {@link PropertyEditor} 示例
 * @Author Xiaoyaoyou
 * @Date: 2020/12/17 11:02
 * @Version 1.0
 *
 * @see PropertyEditor
 */
public class PropertyEditorDemo {

    public static void main(String[] args) {
        //模拟spring framework 操作： 一段文本转 properties

        String text = "name =  逍遥游";

        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();

        propertyEditor.setAsText(text);

        System.out.println(propertyEditor.getValue());

        System.out.println(propertyEditor.getAsText());
    }
}
