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

    @RequestMapping(path = "/like", method = {RequestMethod.POST})
    public int likeTweet(@RequestParam String userId, @RequestParam String tweetId) {
        int likeCount = likeService.likeTweet(Integer.parseInt(userId), Integer.parseInt((tweetId)));
        return likeCount;
    }

    @RequestMapping(path = "/unlike", method = {RequestMethod.POST})
    public int unlikeTweet(@RequestParam String userId, @RequestParam String tweetId) {
        int likeCount = likeService.unLikeTweet(Integer.parseInt(userId), Integer.parseInt(tweetId));
        return likeCount;
    }
}
