package com.dcxuexi;

import com.dcxuexi.config.JedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/***
 * @Title JedisUtilTest
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/30 19:21
 * @Version 1.0.0
 */
@SpringBootTest
public class JedisUtilTest {

    @Autowired
    private JedisPool jedisPool;

    @Test
    void  testJedis(){
        Jedis jedis = jedisPool.getResource();
        jedis.set("jedisStr","NNNNNNN");
        System.out.println(jedis.get("jedisStr"));



        jedis.lpush("jedisHash","how","why","what","where","then");
        jedis.rpush("jedisHash","hello","world");


    }



}



