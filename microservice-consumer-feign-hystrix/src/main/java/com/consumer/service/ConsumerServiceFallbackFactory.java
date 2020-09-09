package com.consumer.service;

import com.common.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsumerServiceFallbackFactory implements FallbackFactory<ConsumerService> {
    @Override
    public ConsumerService create(Throwable throwable) {
        return new ConsumerService() {
            @Override
            public User get(int id) {
                User user = new User(id, "服务已经关闭，或者未找到", 0);
                return user;
            }

            @Override
            public boolean add(User user) {
                return false;
            }

            @Override
            public List<User> getAll() {
                List<User> list = new ArrayList<>();
                User user = new User(0, "服务已经关闭，或者未找到", 0);
                list.add(user);
                return list;
            }
        };
    }
}
