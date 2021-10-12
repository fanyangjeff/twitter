package com.twitter.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class LikeServiceTest {
    private LikeService likeService;

    public LikeServiceTest(@Autowired LikeService likeService) {
        this.likeService = likeService;
    }

    @Test
    void likeTweet() {
        likeService.likeTweet(1, 2);
    }

    @Test
    void unLikeTweet() {
    }
}