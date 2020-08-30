package com.study.thinking.in.spring.ioc.bean.scope.web;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @description:
 * @author: Dailu
 * @time: 2020/8/30 18:22
 */
@Configuration
public class WebConfiguration {

    @Bean
    @RequestScope
    public User user(){
        User user = new User();
        user.setId(12L);
        user.setName("代璐");
        return user;
    }

}
