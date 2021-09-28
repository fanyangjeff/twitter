package com.twitter.entity;

import lombok.Data;

@Data
public class Like {
    private int id;
    private long userId;
    private long tweetId;
    private String date;
}
