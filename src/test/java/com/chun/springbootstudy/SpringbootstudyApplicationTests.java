package com.chun.springbootstudy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootstudyApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testApplication(){
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }

}
