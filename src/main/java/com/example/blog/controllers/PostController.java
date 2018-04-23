package com.example.blog.controllers;
import com.example.blog.models.Post;
import com.example.blog.services.PostSvc;
import com.example.blog.services.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private final UserSvc usrSvc;
    private final PostSvc pstSvc;

    @Autowired
    public PostController(PostSvc pstSvc, UserSvc usrSvc) {
        this.pstSvc = pstSvc;
        this.usrSvc = usrSvc;
    }

    @GetMapping("/posts")
    public String posts( Model model) {
//        retrieves all posts
        Iterable<Post> all = pstSvc.findAll();
        model.addAttribute("Posts", all);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable int id, Model model) {
//        retrieves one single post
        Post onePost = pstSvc.onePost(id);
        model.addAttribute("post", onePost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createGet( Model view) {
//        redirect to create form
        view.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post newPost) {
//        where post is submitted
        newPost.setUser(usrSvc.oneUser(1));
        pstSvc.save(newPost);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String mapCreate(Model model, @PathVariable long id) {
        model.addAttribute("post", pstSvc.onePost(id));
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String edit(@ModelAttribute Post edit, @PathVariable int id) {
//        where post is edited
        pstSvc.edit(id, edit);
        return "redirect:/posts";
    }

}
