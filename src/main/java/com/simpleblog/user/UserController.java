package com.simpleblog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
public class UserController {
    UserService userService;
    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }
}
