package com.chun.springbootstudy.service.imp;

import com.chun.springbootstudy.domain.User;
import com.chun.springbootstudy.mapper.UserMapper;
import com.chun.springbootstudy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /***
     *  每次执行查询之后，方法返回的数据都会被存放在一个本地的Map集合中，然后第二次请求的时候，如果对应的key存在于本地缓存中，那么就不会触发实际的查询方法。
     *  在多线程情况下有可能会存在多个线程并发请求对应的方法。这个时候可以通过使用sync属性去进行限制。
     *  sync=true：并发访问下只能有一个线程将本地缓存进行更新。
     *  sync=false：并发更新本地缓存
     */
    @Cacheable(value = "USERCACHE", key = "#id", sync = true)
    public User getUserInfo(Integer id) {
        LOG.info("从数据库获取用户信息");
        return userMapper.getUserInfo(id);
    }

    //用于删除指定的缓存配置,删除的依据是对应的key属性。
    @CacheEvict(value = "USERCACHE", key = "#id")
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    public int Update(User user) {
        return userMapper.update(user);
    }

    /**
     * 每次出发带有CachePut注解的方法，都会将方法返回结果放入到本地缓存中
     */
    @CachePut(value = "USERCACHE", key = "#user.id")
    public User save(User user) {
        //这是测试：前端要传id，否则会报错
        int save = userMapper.save(user);
        return user;
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
