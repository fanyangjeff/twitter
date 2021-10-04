package com.twitter.service;

import com.twitter.dao.TweetDao;
import com.twitter.dao.UserDao;
import com.twitter.entity.Tweet;
import com.twitter.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TweetService {
    private final TweetDao tweetDao;
    private final UserDao userDao;
    private final DateUtil dateUtil;

    public TweetService(@Autowired TweetDao tweetDao,
                        @Autowired UserDao userDao,
                        @Autowired DateUtil dateUtil) {
        this.tweetDao = tweetDao;
        this.userDao = userDao;
        this.dateUtil = dateUtil;
    }

    public int addTweet(Tweet tweet) {
        int userId = tweet.getUserId();
        boolean userExists = userDao.userExists(userId) != 0;
        if (!userExists || tweet.getContent() == null) {
            return 0;
        }

        //add timestamp
        tweet.setCreatedTime(dateUtil.createTimeStamp());
        tweetDao.createTweet(tweet);

        return 1;
    }

    public List getTweetsByUserId(int userId) {
        boolean userExists = userDao.userExists(userId) != 0;
        if (!userExists)
            return new ArrayList();
        return tweetDao.findAllTweetsByUserId(userId);
    }

    public Map<String, Object> getTweetById(int tweetId) {
        return tweetDao.getTweetById(tweetId);
    }

    public List<Map<String, Object>> getRecentTweets() {
        return tweetDao.getMostTenRecentTweets();
    }

    public void deleteTweetById(int id) {
        tweetDao.deleteTweetById(id);
    }

    public int updateLikeCount(long tweetId, int like) {
        return like;
    }
}
