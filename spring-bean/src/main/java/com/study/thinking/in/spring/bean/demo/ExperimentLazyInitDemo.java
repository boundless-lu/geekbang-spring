package com.study.thinking.in.spring.bean.demo;

import com.study.thinking.in.spring.bean.domain.Experiment;
import com.study.thinking.in.spring.bean.domain.ExperimentRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: Dailu
 * @time: 2020/6/5 16:30
 */
public class ExperimentLazyInitDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/experiment-lazy-init-context.xml");
        System.out.println("ApplicationContext 应用上下文启动完毕。。。");

//        ExperimentRepository bean = context.getBean(ExperimentRepository.class);
//
//
//        Experiment experiment = bean.getExperiment();
    }
}
