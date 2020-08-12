package com.study.thinking.in.spring.bean.factory;

import com.study.thinking.in.spring.ioc.overview.domain.User;

public interface UserFactory {

    default User createInstantiationUser(){
        return User.createUser();
    }
}
