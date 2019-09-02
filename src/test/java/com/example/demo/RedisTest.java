package com.example.demo;

import com.example.demo.entity.Info;
import com.example.demo.entity.User;
import com.example.demo.service.Impl.RedisServiceImpl;
import com.example.demo.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private RedisService redisService;

    @Test
    public void get() {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
        );
        stringRedisTemplate.opsForValue().set("k1", "v1");
        final String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("[字符缓存结果] - [{}]", k1);
        String key = "redis:user:1";
        redisTemplate.opsForValue().set(key, new Info("u1", "pa"));
        final Info info = (Info) redisTemplate.opsForValue().get(key);
        log.info("[对象缓存结果] - [{}]", info);
    }


    @Test
    public void get1(){
        final User user = redisService.saveOrUpdate(new User(5L, "u5", "p5"));
        log.info("[saveOrUpdate]-{}",user);
        final User user1 = redisService.get(user.getId());
        log.info("[get[]]---{}",user1);
        redisService.delete(user1.getId());
    }
}
