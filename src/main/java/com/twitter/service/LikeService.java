package com.twitter.service;

import com.twitter.dao.LikeDao;
import com.twitter.dao.TweetDao;
import com.twitter.dao.UserDao;
import com.twitter.utils.DateUtil;
import com.twitter.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class LikeService {
    private final LikeDao likeDao;
    private final TweetDao tweetDao;
    private final UserDao userDao;
    private final RedisUtil redisUtil;
    private final ExecutorService executorService;

    private String REDIS_PREFIX = "LIKE ";

    public LikeService (@Autowired RedisUtil redisUtil,
                        @Autowired LikeDao likeDao,
                        @Autowired TweetDao tweetDao,
                        @Autowired ExecutorService executorService,
                        @Autowired UserDao userDao) {
        this.redisUtil = redisUtil;
        this.likeDao = likeDao;
        this.executorService = executorService;
        this.tweetDao = tweetDao;
        this.userDao = userDao;
    }

    public int likeTweet(int userId, int tweetId) {
        boolean tweetExists = tweetDao.tweetExists(tweetId) != 0;
        boolean userExists = userDao.userExists(userId) != 0;

        //return 0 if either tweet or user does not exist by looking up its id
        if (!tweetExists || !userExists) {
            return 0;
        }

        /*create a like relationship between a user and a tweet,
        so that we can return a list of tweets liked a user or a list of users liked the tweet
         */
        //likeDao.createLike(userId, tweetId);
        //tweetDao.updateLikeCount(1, tweetId);

        String key = "TESTING";
        redisUtil.set(key, 1);
        if (!redisUtil.hasKey(key)) {
            //redisUtil.set(key, tweetDao.getLikeCountById(tweetId) + 1);
            redisUtil.set(key, 1);
            System.out.println("im here");
        } else {
            //redisUtil.set(key, redisUtil.getInt(key) + 1);
            System.out.println(redisUtil.get(key));
        }
        //System.out.println((int) redisUtil.getInt(key));
        //return tweetDao.getLikeCountById(tweetId);
        return 0;
    }

    public int unLikeTweet(int userId, int tweetId) {
        boolean tweetExists = tweetDao.tweetExists(tweetId) != 0;
        boolean userExists = userDao.userExists(userId) != 0;

        //return 0 if either tweet or user does not exist by looking up its id
        if (!tweetExists || !userExists) {
            return 0;
        }

        //remove like relationship between userId and tweetId from likes table
        int liked = likeDao.removeLike(userId, tweetId);

        //in case the user has never liked the tweet
        if (liked != 0) {
            tweetDao.updateLikeCount(-1, tweetId);
        }
        return tweetDao.getLikeCountById(tweetId);
    }


}
