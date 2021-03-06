package com.study.thinking.in.spring.ioc.overview.domain;

import com.study.thinking.in.spring.ioc.overview.enumerate.City;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class User implements BeanNameAware {

    private Long id;
    private String name;

    private Resource localConfigFile;

    private City city;

    private City[] workCities;

    private List<City> lifeCities;

    private Company company;

    private transient String beanName;

    private Properties context;

    private String contextAsText;

    public static User createUser() {
        User user = new User();
        user.setId(19L);
        user.setName("Static-User-Dailu");
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City[] getWorkCities() {
        return workCities;
    }

    public void setWorkCities(City[] workCities) {
        this.workCities = workCities;
    }

    public List<City> getLifeCities() {
        return lifeCities;
    }

    public void setLifeCities(List<City> lifeCities) {
        this.lifeCities = lifeCities;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Resource getLocalConfigFile() {
        return localConfigFile;
    }

    public void setLocalConfigFile(Resource localConfigFile) {
        this.localConfigFile = localConfigFile;
    }

    public String getContextAsText() {
        return contextAsText;
    }

    public void setContextAsText(String contextAsText) {
        this.contextAsText = contextAsText;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", localConfigFile=" + localConfigFile +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", lifeCities=" + lifeCities +
                ", company=" + company +
                ", beanName='" + beanName + '\'' +
                ", context=" + context +
                ", contextAsText='" + contextAsText + '\'' +
                '}';
    }

    public Properties getContext() {
        return context;
    }

    public void setContext(Properties context) {
        this.context = context;
    }

    @PostConstruct
    public void init(){
        System.out.println("Bean Name :["+beanName+"] 初始化。。。");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean Name :["+beanName+"] 销毁中。。。");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
