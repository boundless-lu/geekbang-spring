package com.study.thinking.in.spring.validation;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Locale;

import static com.study.thinking.in.spring.validation.ErrorMessageDemo.createMessageSource;

/**
 * @Description:  自定义 Spring Validator 校验
 * @Author Xiaoyaoyou
 * @Date: 2020/12/8 15:45
 * @Version 1.0
 */
public class ValidatorDemo {

    public static void main(String[] args) {
        //1.创建Validator
        Validator validator = new UserValidator();

        //2.判断是否支持目标对象类型
        User user = new User();
        System.out.println("UserValidator 是否支持检测User对象："+ validator.supports(User.class));

        //3.创建Errors对象
        Errors errors = new BeanPropertyBindingResult(user,"user");
        validator.validate(user,errors);

        //4.获取messageSource对象
        MessageSource messageSource = createMessageSource();

        //5.输出所有错误文案
        for (ObjectError error : errors.getAllErrors()){
            System.out.println(messageSource.getMessage(error.getCode(),error.getArguments(), Locale.getDefault()));
        }

    }


    static class UserValidator implements Validator{

        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","name.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id","id.required");
        }
    }
}
