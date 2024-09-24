package com.example.twitterapp.controller;

import com.example.twitterapp.model.Post;
import com.example.twitterapp.repository.PostRepository;
import com.example.twitterapp.service.PostService;
import com.example.twitterapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model)
    {
        List<Post> posts = postService.findAll();
        model.addAttribute("post", posts);
        return "home";
    }

    @GetMapping("/add")
    public String showAddPostForm(Model model)
    {
        model.addAttribute("post", new Post());
        return "add";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute Post post)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication()
    }
}