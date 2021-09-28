package com.twitter.service;

import com.twitter.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class UserService {
    private final UserDao userDao;
    private final ExecutorService executorService;

    public UserService(@Autowired UserDao userDao, @Autowired ExecutorService executorService) {
        this.userDao = userDao;
        this.executorService = executorService;
    }

    public void follow(int followerId, int followeeId) {
        boolean followerExists = userDao.userExists(followeeId) != 0;
        boolean followeeExists = userDao.userExists(followeeId) != 0;
        boolean followed = userDao.hasFollowed(followerId, followeeId) != 0;
        System.out.println(followed);
        //if either user does not exist or the follower has already followed the followee
        if (!followerExists || !followeeExists || followed) {
            return;
        }
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                    userDao.createFollowRelationship(followerId, followeeId);
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.incrementFolloweeById(followerId);
                userDao.incrementFollowerById(followeeId);
            }
        });

    }

    public void unfollow(int followerId, int followeeId) {
        boolean followerExists = userDao.userExists(followeeId) != 0;
        boolean followeeExists = userDao.userExists(followeeId) != 0;
        boolean followed = userDao.hasFollowed(followerId, followeeId) != 0;

        //if either user does not exist or the follower has not followed the followee
        if (!followerExists || !followeeExists || !followed) {
            return;
        }

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.removeFollowRelationShip(followerId, followeeId);
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.decrementFolloweeById(followerId);
                userDao.decrementFollowerById(followeeId);
            }
        });
    }
}
