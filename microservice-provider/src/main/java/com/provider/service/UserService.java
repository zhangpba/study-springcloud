package com.provider.service;

import com.common.entity.User;

import java.util.List;

public interface UserService {
    public boolean addUser(User user);

    public User getUser(int id);

    public List<User> getUsers();
}
