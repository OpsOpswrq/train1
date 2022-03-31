package com.feng.service;

import com.feng.dao.UserDao;
import com.feng.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDao{
    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> selectUser(User user) {
        return userDao.selectUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public List<User> selectUser1(String name) {
        return userDao.selectUser1(name);
    }
}
