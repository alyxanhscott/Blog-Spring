package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "viewing posts";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id) {
        return "post at id#: " + id;
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String createGet() {
        return "Form for creating a post(Get)";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a post here(Post)";
    }

}