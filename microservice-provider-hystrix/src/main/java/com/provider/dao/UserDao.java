package com.provider.dao;

import com.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    public boolean addUser(User user);

    public User getUser(int id);

    public List<User> getUsers();
}
