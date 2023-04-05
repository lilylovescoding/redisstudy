package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisspringbootApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        // redisTemplate 操作不同的数据类型，api跟那8种指令一样
        // opsForValue 操作字符串  =String
        //opsForList  操作List  =List
        //opsForSet
        //opsForHash
        //opsForZSet
        //opsForGeo
        //opsForHyperLogLog

        //还可直接通过redisTemplate操作，如事务和基本的CRUD操作

        //获取redis的连接对象
        //  redisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //  connection.flushDb();
        //  connection.flushAll();
        redisTemplate.opsForValue().set("mykey", "lily");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }
}
