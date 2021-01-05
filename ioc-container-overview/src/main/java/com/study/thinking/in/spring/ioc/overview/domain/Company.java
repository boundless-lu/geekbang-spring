package com.study.thinking.in.spring.ioc.overview.domain;

/**
 * @Description: Company
 * @Author Xiaoyaoyou
 * @Date: 2020/12/15 16:35
 * @Version 1.0
 */
public class Company {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
