package com.twitter.controller;

import com.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/follow", method = {RequestMethod.GET, RequestMethod.POST})
    public void follow(@RequestParam String followerId, @RequestParam String followeeId) {
        userService.follow(Integer.parseInt(followerId), Integer.parseInt(followeeId));
    }

    @RequestMapping(path = "/unfollow", method = {RequestMethod.GET, RequestMethod.POST})
    public void unfollow(@RequestParam String followerId, @RequestParam String followeeId) {
        userService.unfollow(Integer.parseInt(followerId), Integer.parseInt(followeeId));
    }

    @RequestMapping(path = "/followeeList", method = {RequestMethod.GET})
    public List<Map<String, Object>> getFolloweeList(@RequestParam String id) {
        return userService.getFolloweeList(Integer.parseInt(id));
    }

    @RequestMapping(path = "/followerList", method = {RequestMethod.GET})
    public List<Map<String, Object>> getFollowerList(@RequestParam String id) {
        return userService.getFollowerList(Integer.parseInt(id));
    }
}
