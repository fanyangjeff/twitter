package com.twitter.entity;

import lombok.Data;

@Data
public class Notification {
    private int id;
    private long userOneId;
    private long userTwoId;
    private String message;
    private String date;
    //1 stands for read, 0 stands for unread
    private int isRead;
}
