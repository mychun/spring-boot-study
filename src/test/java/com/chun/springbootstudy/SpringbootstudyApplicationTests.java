package com.chun.springbootstudy;

import com.alibaba.fastjson.JSON;
import com.chun.springbootstudy.domain.User;
import com.chun.springbootstudy.service.Fruit;
import com.chun.springbootstudy.service.imp.RedisServiceImpl;
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

    @Resource
    RedisServiceImpl redisService;
    @Test
    public void testString(){
        String key = "lisi";
        String value = "第一名";
        redisService.setString(key, value);
        System.out.println(redisService.getString(key));
    }

    @Test
    public void testHash(){
        String key = "userId";
        String userId = "1";
        User user = new User();
        user.setName("Mike");
        user.setAge(18);
//        redisService.setHash(key, userId, JSON.toJSONString(user));
//        System.out.println(redisService.getHash(key, userId));

        User user1 = JSON.parseObject(redisService.getHash(key, userId), User.class);
        System.out.println(user1);
    }

    @Test
    public void TestList() {
        String key="lisi";
        redisService.leftPushList(key,"1");
        redisService.leftPushList(key,"2");
        redisService.leftPushList(key,"3");
//        System.out.println(redisService.rightPopList(key));
        System.out.println("all:"+redisService.getRange(key,0,-1));

    }
}
