package com.feng.dao;

import com.feng.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    void addUser(User user);
    List<User> selectUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> selectUser1(String name);
}
