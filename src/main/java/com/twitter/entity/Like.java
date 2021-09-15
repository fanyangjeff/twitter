package com.twitter.entity;

import lombok.Data;

@Data
public class Like {
    private long id;
    private long userId;
    private long tweetId;
    private String date;
}
