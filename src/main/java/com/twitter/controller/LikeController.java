package com.twitter.controller;

import com.twitter.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LikeController {
    private final LikeService likeService;

    public LikeController(@Autowired LikeService likeService) {
        this.likeService = likeService;
    }

    @RequestMapping(path = "/like/{userId}/{tweetId}", method = {RequestMethod.GET, RequestMethod.POST})
    public int likeTweet(@PathVariable("userId") String userId, @PathVariable("tweetId") String tweetId) {
        likeService.likeTweet(Long.parseLong(userId), Long.parseLong((tweetId)));
        return 1;
    }

    @RequestMapping(path = "/unlike/{userId}/{tweetId}", method = {RequestMethod.GET, RequestMethod.POST})
    public int unlikeTweet(@PathVariable("userId") String userId, @PathVariable("tweetId") String tweetId) {
        likeService.unLikeTweet(Long.parseLong(userId), Long.parseLong(tweetId));
        return 1;
    }
}
