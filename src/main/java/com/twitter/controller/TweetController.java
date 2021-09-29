package com.twitter.controller;

import com.twitter.entity.Tweet;
import com.twitter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TweetController {
    private final TweetService tweetService;

    public TweetController(@Autowired TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @RequestMapping(path = "/tweet", method = {RequestMethod.POST})
    int createTweet(@RequestBody Tweet tweet) {
        return tweetService.addTweet(tweet);
    }


    @RequestMapping(path = "/tweets", method = {RequestMethod.GET})
    List<Map<String, Object>> getAllTweets(@RequestParam("userId") String userId) {
        return tweetService.getTweetsById(Integer.parseInt(userId));
    }
}
