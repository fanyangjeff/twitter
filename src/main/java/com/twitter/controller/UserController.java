package com.twitter.controller;

import com.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/follow", method = {RequestMethod.GET, RequestMethod.PUT})
    public void follow(@RequestParam String followerId, @RequestParam String followeeId) {

    }

    @RequestMapping(path = "/unfollow", method = {RequestMethod.GET, RequestMethod.PUT})
    public void unfollow(@RequestParam String followerId, @RequestParam String followeeId) {

    }
}
