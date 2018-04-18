package com.example.blog.controllers;
import com.example.blog.models.Post;
import com.example.blog.services.PostSvc;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private final PostSvc pstSvc;

    public PostController(PostSvc pstSvc) {
        this.pstSvc = pstSvc;
    }

    @GetMapping("/posts")
    public String posts( Model model) {
//        retrieves all posts
        List<Post> all = pstSvc.allPosts();
        model.addAttribute("Posts", all);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable int id, Model model) {
//        retrieves one single post
        Post onePost = pstSvc.onePost(id);
        model.addAttribute("post", onePost);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String createGet( Model view) {
//        redirect to create form
        view.addAttribute("newPost", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post newPost) {
//        where post is submitted
        pstSvc.save(newPost);
        return "redirect:/posts";
    }

}
