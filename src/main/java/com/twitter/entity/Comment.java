package com.twitter.entity;

import lombok.Data;

@Data
public class Comment {
    private int id;
    private String content;
    private long userId;
    private long tweetId;
    private String date;

}
