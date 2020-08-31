package com.study.thinking.in.spring.ioc.bean.scope.web;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @description:
 * @author: Dailu
 * @time: 2020/8/30 18:22
 */
@Configuration
//@EnableWebMvc
public class WebConfiguration {

    @Bean
//    @RequestScope  //注入的Bean是同一个，但是AbstractRequestAttributesScope#get方法每个请求返回前端的对象都不同。
    @SessionScope    //注入的Bean是同一个，AbstractRequestAttributesScope#get方法在相同session下每个请求返回前端的对象都相同。
//    @ApplicationScope
    public User user(){
        User user = new User();
        user.setId(12L);
        user.setName("代璐");
        return user;
    }

}
