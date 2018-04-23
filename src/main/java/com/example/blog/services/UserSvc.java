package com.example.blog.services;

import com.example.blog.models.User;
import com.example.blog.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
