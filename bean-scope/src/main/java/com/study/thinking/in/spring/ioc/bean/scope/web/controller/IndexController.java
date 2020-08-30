package com.study.thinking.in.spring.ioc.bean.scope.web.controller;

import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String index(Model model){
        model.addAttribute("userObject",user);
        return "index";
    }
}
