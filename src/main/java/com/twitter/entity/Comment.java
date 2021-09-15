package com.twitter.entity;

import lombok.Data;

@Data
public class Comment {
    private long id;
    private String content;
    private long userId;
    private long tweetId;
    private String date;

}
