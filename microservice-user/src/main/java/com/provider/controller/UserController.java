package com.provider.controller;

import com.common.entity.User;
import com.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        boolean flag = userService.addUser(user);
        return flag;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        return user;
    }

    @RequestMapping(value = "/getUser/list", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = userService.getUsers();
        return users;
    }

    @GetMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setAge(100000);
        user.setUserName("测试新写的接口");
        return user;
    }
}
