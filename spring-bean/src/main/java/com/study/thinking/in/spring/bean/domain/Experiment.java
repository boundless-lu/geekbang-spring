package com.study.thinking.in.spring.bean.domain;

/**
 * @description:
 * @author: Dailu
 * @time: 2020/6/5 16:22
 */
public class Experiment {

    private String name;
    private Long counts;


    public void initMethod(){
        System.out.println("Experiment 初始化方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCounts() {
        return counts;
    }

    public void setCounts(Long counts) {
        this.counts = counts;
    }
}
