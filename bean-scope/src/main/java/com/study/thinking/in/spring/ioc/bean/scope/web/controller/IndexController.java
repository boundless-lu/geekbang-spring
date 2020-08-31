package com.study.thinking.in.spring.ioc.bean.scope.web.controller;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: Dailu
 * @time: 2020/8/30 18:20
 */
@Controller
public class IndexController {

    @Autowired
    private User user;

    @GetMapping("/index")
    public String index(ServletServerHttpResponse response, Model model){
        //如果想使用${userObject.name}EL标签取值，则必须将对象加入到页面渲染对象Model中。
        model.addAttribute("userObject",user);


        //如果使用  ${applicationScope['scopedTarget.user'].name
        //          ${sessionScope['scopedTarget.user'].name
        //等作用域相关标签取值，则不必使用model.addAttribute。只需Bean对象被注入即可,
        //但此时Scope中Bean对应的key值，即bean名称并不等于代码中注解@Bean的名称，需要加上scopedTarget.
        System.out.println(user.getName());
        return "index";

    }
}
