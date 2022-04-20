package com.chun.springbootstudy.config;

import com.chun.springbootstudy.domain.Pet;
import com.chun.springbootstudy.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //告诉springboot这是一个配置类 == 配置文件
public class Myconfig {

    @Bean
    public User user01(){
        return new User("用户", 23);
    }

    @Bean("德玛西亚")
    public Pet pet10(){
        return new Pet("旺财");
    }
}
