package com.example.blog.services;

import com.example.blog.models.Post;
import com.example.blog.models.User;
import com.example.blog.models.UserRepository;
import com.example.blog.models.postInterface;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserSvc {

    private UserRepository userDao;

    @Autowired
    public UserSvc(UserRepository userDao) {
        this.userDao = userDao;
    }

    public Iterable<User> findAllUsers() {
        return userDao.findAll();
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public User oneUser(long id) {
        return userDao.findOne(id);
    }

    public void  deleteUser(long id) {
        userDao.delete(id);
    }
}
