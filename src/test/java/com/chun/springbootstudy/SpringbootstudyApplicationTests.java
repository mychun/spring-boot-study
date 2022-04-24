package com.chun.springbootstudy;

import com.chun.springbootstudy.service.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootstudyApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testApplication(){
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }

//    @Autowired //由于有多个bean会直接报错
    @Resource(name = "apple")
    Fruit fruit;
    @Test
    void testFruit(){
        fruit.sell();
    }
}
