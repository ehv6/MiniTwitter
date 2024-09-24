package com.example.twitterapp.repository;

import com.example.twitterapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing Post entities
public interface PostRepository extends JpaRepository<Post, Long> {
    // JpaRepository provides basic CRUD operations and more
}
