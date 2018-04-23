package com.example.blog.controllers;
import com.example.blog.models.Post;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    List<Post> post = Arrays.asList(
            new Post("Coding Coding Coding...", "Always Coding, always thriving on caffeine."),
            new Post("Shinedown 2018!", "Shinedown was awesome as always!"),
            new Post("Guinea Piggies!", "Insert something about your guineas here...")
    );

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("Posts", post);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id, Model model) {
        Post post = new Post("Test post", "test describe");
        model.addAttribute("post", post);
        return "/posts/show";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String createGet() {
        return "Form for creating a post(Get)";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a post here(com.example.blog.models.Post)";
    }

}
