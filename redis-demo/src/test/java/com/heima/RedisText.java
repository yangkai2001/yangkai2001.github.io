package com.heima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heima.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
public class RedisText {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("name", "叶凡");
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name=" + name);
    }
private static final ObjectMapper mapper=new ObjectMapper();
    @Test
    void textset() throws JsonProcessingException {
        //创建对象
        user user = new user("叶凡", 20);
        //手动序列化
        String s = mapper.writeValueAsString(user);
        //写入数据
        stringRedisTemplate.opsForValue().set("user:100",s);

        String s1 = stringRedisTemplate.opsForValue().get("user:100");
        //手动反序列化
        user user1 = mapper.readValue(s1,user.class);
        System.out.println("学生="+user1);

    }
    @Test
    void textHsth(){
        stringRedisTemplate.opsForHash().put("User:200","name","荒");
        stringRedisTemplate.opsForHash().put("User:200","age","18");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("User:200");
        System.out.println("对象="+entries);

    }
}
