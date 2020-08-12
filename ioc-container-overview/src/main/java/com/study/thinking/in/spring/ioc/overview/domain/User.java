package com.study.thinking.in.spring.ioc.overview.domain;

public class User {

    private Long id;
    private String name;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
