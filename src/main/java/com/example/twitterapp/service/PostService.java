package com.example.twitterapp.service;

import com.example.twitterapp.model.Post;
import com.example.twitterapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Save a post with the current timestamp
    public void save(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
    }

    // Retrieve all posts
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
