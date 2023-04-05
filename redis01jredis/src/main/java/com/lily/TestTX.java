package com.lily;

import org.json.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);   //开启连接

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "lily");
        jsonObject.put("hello", "susie");

        //开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toString();

        try {
            multi.set("user1", result);
            multi.set("user2", result);
            multi.exec();
        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }

        jedis.close();  //关闭连接
    }
}
