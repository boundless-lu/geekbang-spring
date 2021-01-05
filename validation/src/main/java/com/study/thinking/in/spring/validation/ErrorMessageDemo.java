package com.study.thinking.in.spring.validation;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * @Description:  错误文案示例
 * @Author Xiaoyaoyou
 * @Date: 2020/12/7 16:08
 * @Version 1.0
 *
 * @see Errors
 */
public class ErrorMessageDemo {

    public static void main(String[] args) {
        //0. 生成User对象
        User user = new User();
        user.setName("boundless");

        //1.选择Errors --- BeanPropertyBindingResult
        Errors errors = new BeanPropertyBindingResult(user,"user");

        //2.
        //调用reject生成ObjectError
        //调用rejectValue生成FieldError
        errors.reject("user.properties.not.null");
        errors.rejectValue("name","name.required");

        MessageSource messageSource = createMessageSource();


        //3. 获取Errors中的ObjectError和FieldError
        List<ObjectError> allErrors = errors.getAllErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<ObjectError> globalErrors = errors.getGlobalErrors();


        //4. 通过ObjectError和FieldError中的code和args关联 MessageSource实现
        for (ObjectError error : allErrors){
            System.out.println(messageSource.getMessage(error.getCode(),error.getArguments(),Locale.getDefault()));
        }

    }


    static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("id.required", Locale.getDefault(),"user id must not be empty");
        messageSource.addMessage("name.required", Locale.getDefault(),"user name must not be empty");
        messageSource.addMessage("user.properties.not.null", Locale.getDefault(),"用户属性不能为空");
        return messageSource;
    }

}
