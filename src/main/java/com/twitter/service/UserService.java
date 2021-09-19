package com.twitter.service;

import com.twitter.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    public void follow(long followerId, long followeeId) {
        System.out.println(followerId);
        System.out.println(followeeId);
    }

    public void unfollow(long followerId, long followeeId) {
        System.out.println(followerId);
        System.out.println(followeeId);
    }
}
