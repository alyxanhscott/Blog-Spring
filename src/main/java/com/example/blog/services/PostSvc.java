package com.example.blog.services;

import com.example.blog.models.Post;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostSvc {

    List<Post> posts;

    public PostSvc() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> allPosts() {
        return posts;
    }

    public Post save(Post post) {
        post.setId((long) posts.size() + 1);
        posts.add(post);
        return post;
    }
    public Post onePost(long id) {
        return posts.get((int) id - 1);
    }

    public void edit(long id, Post post) {
        posts.get((int)id).setTitle(post.getTitle());
        posts.get((int)id).setBody(post.getBody());

    }

    public void createPosts() {
        save(new Post("Coding Coding Coding...", "Always Coding, always thriving on caffeine."));
        save(new Post("Shinedown 2018!", "Shinedown was awesome as always!"));
        save(new Post("Guinea Piggies!", "Insert something about your guineas here..."));
    }
}
