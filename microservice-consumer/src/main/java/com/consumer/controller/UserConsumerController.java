package com.consumer.controller;

import com.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserConsumerController {

    // private static String REST_URL_PREFIX = "http://localhost:8002";
    // 直接根据微服务名，而不是根据地址和端口了，运用eureka的发现功能
    private static String REST_URL_PREFIX = "http://microservice-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/add")
    public boolean addUser(User user) {
        System.out.println(user.getUserName());
        System.out.println(REST_URL_PREFIX + "/add");
        Boolean flag = restTemplate.postForObject(REST_URL_PREFIX + "/add", user, Boolean.class);
        return flag;
    }

    @RequestMapping(value = "/consumer/get/{id}")
    public User get(@PathVariable("id") int id) {
        System.out.println(id);
        System.out.println(REST_URL_PREFIX + "/get/" + id);
        User user = restTemplate.getForObject(REST_URL_PREFIX + "/get/" + id, User.class);
        return user;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/consumer/list")
    public List<User> getList() {
        List list = restTemplate.getForObject(REST_URL_PREFIX + "/getUser/list", List.class);
        return list;
    }
}
