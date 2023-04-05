package com.lily;

import redis.clients.jedis.Jedis;

import javax.sound.midi.Soundbank;

public class TestPing {
    public static void main(String[] args) {
        //1. 测试连接
        // new 一个jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //jedis可以查看jedis所有的命令

        System.out.println(jedis.ping());
        System.out.println("清空数据：" + jedis.flushDB());
        System.out.println("判断某个键是否存在：" + jedis.exists("username"));
    }
}
