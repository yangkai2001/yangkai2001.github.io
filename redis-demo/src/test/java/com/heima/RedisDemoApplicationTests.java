package com.heima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import com.heima.pojo.user;


@SpringBootTest
class RedisDemoApplicationTests {
    @Autowired
   private RedisTemplate<String,Object> redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name","荒");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name="+name);
    }
    @Test
    void textset(){
        redisTemplate.opsForValue().set("user:100",new user("huang",20));

        user o = (user) redisTemplate.opsForValue().get("user:100");
        System.out.println("o="+o);

    }

}
