package com.chun.springbootstudy.config;

import com.chun.springbootstudy.condition.AppleCondition;
import com.chun.springbootstudy.condition.BananaCondition;
import com.chun.springbootstudy.service.Fruit;
import com.chun.springbootstudy.service.imp.Apple;
import com.chun.springbootstudy.service.imp.Banana;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConditionConfig {
    @Bean
    // @Conditional(AppleCondition.class) //会根据条件，是否注入
    @ConditionalOnProperty(value = "fruit.name", havingValue = "apple", matchIfMissing = true)
    public Fruit apple(){
        return new Apple();
    }

    @Bean
    // @Conditional(BananaCondition.class) //会根据条件，是否注入
    @ConditionalOnProperty(value = "fruit.name", havingValue = "banana")
    public Fruit banana(){
        return new Banana();
    }
}
