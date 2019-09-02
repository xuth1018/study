package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RedisServiceImpl implements RedisService {

    private static final Map<Long, User> DATABASES = new HashMap<>();

    static {
        DATABASES.put(1L, new User(1L, "u1", "p1"));
        DATABASES.put(2L, new User(2L, "u2", "p2"));
        DATABASES.put(3L, new User(3L, "u3", "p3"));
    }

    private static final Logger log = LoggerFactory.getLogger(RedisServiceImpl.class);

    @CachePut(value = "user" , key = "#user.id")
    @Override
    public User saveOrUpdate(User user) {
        log.info("进入 saveOrUpdate 方法");
        DATABASES.put(user.getId(),user);
        return user;
    }

    @Cacheable(value =  "user",key = "#id")
    @Override
    public User get(Long id) {
        log.info("进入 get 方法");
        return DATABASES.get(id);
    }

    @CacheEvict(value = "user",key = "#id")
    @Override
    public void delete(Long id) {
        DATABASES.remove(id);
        log.info("进入 delete 方法");
    }
}
