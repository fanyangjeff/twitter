package com.twitter.service;

import com.twitter.dao.LikeDao;
import com.twitter.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class LikeService {
    private final LikeDao likeDao;
    private final RedisUtil redisUtil;
    private final ExecutorService executorService;

    public LikeService (@Autowired RedisUtil redisUtil, @Autowired LikeDao likeDao, @Autowired ExecutorService executorService) {
        this.redisUtil = redisUtil;
        this.likeDao = likeDao;
        this.executorService = executorService;
    }

    public int likeTweet(long tweetId, long userId) {

        return 1;

    }

    public int unLikeTweet(long tweetId, long userId) {
        return 1;
    }


}
