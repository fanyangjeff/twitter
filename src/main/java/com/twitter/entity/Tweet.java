package com.twitter.entity;

import lombok.Data;

@Data
public class Tweet {
    private long id;
    private String content;
    private String createdTime;
    private long userId;
    private long commentCount;
    private long likeCount;
}
