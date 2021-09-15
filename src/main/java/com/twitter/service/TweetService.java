package com.twitter.service;

import com.twitter.entity.Tweet;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
    public int addTweet(Tweet tweet) {
        return 0;
    }

    public int updateLikeCount(long tweetId, int like) {
        return like;
    }
}
