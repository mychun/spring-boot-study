package com.chun.springbootstudy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="classpath:my-application.properties", encoding="UTF-8")
public class GetMyApplicationPropertiesByValue {
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private Integer age;

    @Value("${my.type}")
    private String type;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "GetMyApplicationProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }
}
