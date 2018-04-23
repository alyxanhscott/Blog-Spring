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
public class PostSvc {

    private postInterface postInterfaceDao;

    List<Post> posts;

    @Autowired
    public PostSvc(postInterface postInterfaceDao) {
        this.postInterfaceDao = postInterfaceDao;
    }

    public Iterable<Post> findAll() {
        return postInterfaceDao.findAll();
    }

    public Post save(Post post) {
        postInterfaceDao.save(post);
        return postInterfaceDao.save(post);
    }

    public Post onePost(long id) {
        return postInterfaceDao.findOne(id);
    }

    public void deletePost(long id) {
        postInterfaceDao.delete(id);
    }

    public void edit(long id, Post post) {
        posts.get((int)id).setTitle(post.getTitle());
        posts.get((int)id).setBody(post.getBody());

    }

}
