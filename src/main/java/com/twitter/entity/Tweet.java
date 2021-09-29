package com.twitter.entity;

import lombok.Data;

@Data
public class Tweet {
    private int id;
    private String content;
    private String createdTime;
    private int userId;
    private int commentCount;
    private int likeCount;
}
