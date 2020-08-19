package com.study.thinking.in.spring.ioc.overview.domain;

import com.study.thinking.in.spring.ioc.overview.enumerate.City;
import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.List;

public class User {

    private Long id;
    private String name;

    private Resource localConfigFile;

    private City city;

    private City[] workCities;

    private List<City> lifeCities;

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

    public Resource getLocalConfigFile() {
        return localConfigFile;
    }

    public void setLocalConfigFile(Resource localConfigFile) {
        this.localConfigFile = localConfigFile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", lifeCities=" + lifeCities +
                ", localConfigFile=" + localConfigFile +
                '}';
    }
}
