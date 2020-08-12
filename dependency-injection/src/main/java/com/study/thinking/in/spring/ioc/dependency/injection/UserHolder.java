package com.study.thinking.in.spring.ioc.dependency.injection;

import com.study.thinking.in.spring.ioc.overview.domain.User;

/**
 * @Description: UserHolder
 * @Author Xiaoyaoyou
 * @Date: 2020/8/6 17:37
 * @Version 1.0
 */
public class UserHolder {

    private User user;

    public UserHolder(){}

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
