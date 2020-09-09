package com.consumer.service;

import com.common.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 2020-04-16
 */
@FeignClient(value = "microservice-user")
public interface UserService {

    @GetMapping("/getUser")
    public User getUser();
}
