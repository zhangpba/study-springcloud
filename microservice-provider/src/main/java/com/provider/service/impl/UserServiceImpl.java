package com.provider.service.impl;

import com.common.entity.User;
import com.provider.dao.UserDao;
import com.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        System.out.println("microservice-provider微服务在响应客户端请求……");
        boolean flag;
        flag = userDao.addUser(user);
        return flag;
    }

    @Override
    public User getUser(int id) {
        User user = userDao.getUser(id);
        System.out.println("microservice-provider微服务在响应客户端请求……");
        System.out.println("user : " + user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        System.out.println("microservice-provider微服务在响应客户端请求……");
        List<User> users = userDao.getUsers();
        return users;
    }
}
