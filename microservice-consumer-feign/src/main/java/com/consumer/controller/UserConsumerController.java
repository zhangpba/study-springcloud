package com.consumer.controller;

import com.common.entity.User;
import com.consumer.service.ConsumerService;
import com.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserConsumerController {

    // private static String REST_URL_PREFIX = "http://localhost:8002";
    // 直接根据微服务名，而不是根据地址和端口了，运用eureka的发现功能
//    private static String REST_URL_PREFIX = "http://microservice-provider";
//
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/consumer/add")
    public boolean addUser(User user) {
        System.out.println(user.getUserName());
        Boolean flag = consumerService.add(user);
        return flag;
    }

    @RequestMapping(value = "/consumer/get/{id}")
    public User get(@PathVariable("id") int id) {
        System.out.println(id);
        User user = consumerService.get(id);
        return user;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/consumer/list")
    public List<User> getList() {
        List list = consumerService.getAll();
        return list;
    }

    @GetMapping("/getUser")
    public User getUser(){
        return userService.getUser();
    }
}
