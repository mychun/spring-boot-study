package com.chun.springbootstudy.domain;

import lombok.Data;

@Data
public class User {
    private String name;
    private Integer age;
    private Integer id;
    private String acount;
    private String password;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", acount='" + acount + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
