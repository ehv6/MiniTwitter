package com.example.twitterapp.controller;

import com.example.twitterapp.config.CustomUserDetails;
import com.example.twitterapp.model.Post;
import com.example.twitterapp.service.PostService;
import com.example.twitterapp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String home(Model model) {
        List<Post> posts = postService.findAll(); // Fetch all posts
        model.addAttribute("posts", posts); // Add posts to the model
        return "home";
    }

    @GetMapping("/add")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new Post()); // Prepare an empty post for the form
        return "add";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute Post post) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        var existingUser = userService.findByUsername(user.getUsername()); // Find current user
        post.setUser(existingUser); // Associate post with the user
        postService.save(post); // Save the post
        return "redirect:/";
    }
}
