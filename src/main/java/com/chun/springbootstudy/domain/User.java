package com.chun.springbootstudy.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class User {

    @NotBlank(message = "名字为必填")
    private String name;
    private Integer age;
    private Integer id;
    @NotBlank(message = "账户为必填")
    private String account;
    @Length(min = 8, max = 12, message = "密码长度必须位于8到12之间")
    private String password;
    @Email(message = "请填写正确的邮箱地址")
    private String email;

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
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
