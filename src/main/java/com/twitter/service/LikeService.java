package com.twitter.service;

import com.twitter.dao.LikeDao;
import com.twitter.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeDao likeDao;
    private final RedisUtil redisUtil;

    public LikeService (@Autowired RedisUtil redisUtil, @Autowired LikeDao likeDao) {
        this.redisUtil = redisUtil;
        this.likeDao = likeDao;
    }


}
