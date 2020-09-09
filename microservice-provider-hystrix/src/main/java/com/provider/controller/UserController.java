package com.provider.controller;

import com.common.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hystrixGetUser") //一旦服务调用失败，就会调用hystrixGetUser方法
    public User getUser(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new RuntimeException("不存在id=" + id + "对应的用户信息");
        }
        System.out.println("provider查出的 user:" + user.toString());
        return user;
    }

    public User hystrixGetUser(@PathVariable("id") int id) {
        User user = new User(id, "不存在该用户", 0);
        System.out.println("异常回掉函数的创建的userName=" + user.getUserName());
        return user;
    }
}
