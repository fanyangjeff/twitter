package com.twitter.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
    private final long EXPIRE_TIME = 60;
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisUtil (@Autowired RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean set (String key, Object value, long expireTime) {
        try {
            if (expireTime < 0) {
                return this.set(key, value);
            }
            redisTemplate.opsForValue().set(key, value, expireTime);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean set (String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value, EXPIRE_TIME);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hasKey (String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
