package com.heima.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class redisconfig {
@Bean
public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory connectionFactory){
    //创建redistemplate对象
RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();

    //设置连接工厂
redisTemplate.setConnectionFactory(connectionFactory);

    //创建json的序链化工具
    GenericJackson2JsonRedisSerializer rediss = new GenericJackson2JsonRedisSerializer();
    //设置key的序列化
redisTemplate.setKeySerializer(RedisSerializer.string());
redisTemplate.setHashKeySerializer(RedisSerializer.string());

    //设置valu的序列化
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.setHashValueSerializer(RedisSerializer.json());

    //返回
return redisTemplate;

}


}
