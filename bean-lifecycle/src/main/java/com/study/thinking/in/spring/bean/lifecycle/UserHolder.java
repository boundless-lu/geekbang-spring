package com.study.thinking.in.spring.bean.lifecycle;

import com.study.thinking.in.spring.ioc.overview.domain.User;

/**
 * @Description: UserHolder
 * @Author Xiaoyaoyou
 * @Date: 2020/9/8 11:26
 * @Version 1.0
 */
public class UserHolder {

    private final User user;

    private Integer number;

    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public UserHolder(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }
}
