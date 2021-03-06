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
        return tweetService.getTweetsByUserId(Integer.parseInt(userId));
    }

    @RequestMapping(path = "/tweet/{id}", method = {RequestMethod.GET})
    Map<String, Object> getTweetById(@PathVariable("id") String id) {
        return tweetService.getTweetById(Integer.parseInt(id));
    }

    @RequestMapping(path = "/tweet/feeds", method = {RequestMethod.GET})
    List<Map<String, Object>> getRecentTweets() {
        return tweetService.getRecentTweets();
    }

    @RequestMapping(path = "/tweet", method = {RequestMethod.DELETE})
    void removeTweetById(@RequestParam("id") String id) {
        tweetService.deleteTweetById(Integer.parseInt(id));
    }
}
