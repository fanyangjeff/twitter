package com.twitter.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    private final long EXPIRE_TIME = 20;
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisUtil (@Autowired RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean set (String key, Object value, long expireTime) {
        try {
            if (expireTime < 0) {
                this.set(key, value);
                return true;
            }
            redisTemplate.opsForValue().set(key, value, expireTime);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void set (String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value, EXPIRE_TIME, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
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

    public Integer getInt (String key) {
        try {
            return (Integer) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object get (String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Object();
    }
}
