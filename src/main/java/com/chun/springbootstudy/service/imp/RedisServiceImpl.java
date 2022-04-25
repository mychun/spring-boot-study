package com.chun.springbootstudy.service.imp;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RedisServiceImpl {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String vaule){
        final ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(key, vaule);
    }
    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void setHash(String key, String fieldKey, String value){
        stringRedisTemplate.opsForHash().put(key, fieldKey, value);
    }
    public String getHash(String key, String fieldKey){
        return (String) stringRedisTemplate.opsForHash().get(key, fieldKey);
    }

    public void leftPushList(String key, String value) {
        stringRedisTemplate.opsForList().leftPush(key,value);
    }

    public String rightPopList(String key) {
        return stringRedisTemplate.opsForList().rightPop(key);
    }

    public List<String> getRange(String key, int start, int end) {
        return stringRedisTemplate.opsForList().range(key,start,end);
    }
}
