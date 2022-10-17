package com.dcxuexi.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/***
 * @Title RedisUtil
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/9/27 21:40
 * @Version 1.0.0
 */
public class RedisUtil {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public Boolean redisSet(String key, Object value){
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set(key, value);
        return true;
    }


}
