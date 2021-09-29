package com.twitter.service;

import com.twitter.dao.LikeDao;
import com.twitter.utils.DateUtil;
import com.twitter.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutorService;

@Service
public class LikeService {
    private final LikeDao likeDao;
    private final RedisUtil redisUtil;
    private final ExecutorService executorService;
    private final DateUtil dateUtil;

    private String REDIS_PREFIX = "LIKE+";

    public LikeService (@Autowired RedisUtil redisUtil,
                        @Autowired LikeDao likeDao,
                        @Autowired ExecutorService executorService,
                        @Autowired DateUtil dateUtil) {
        this.redisUtil = redisUtil;
        this.likeDao = likeDao;
        this.executorService = executorService;
        this.dateUtil = dateUtil;
    }

    public int likeTweet(int tweetId, int userId) {

        System.out.println(dateUtil.createTimeStamp());


        return 1;

    }

    public int unLikeTweet(int tweetId, int userId) {

        return 1;
    }


}
