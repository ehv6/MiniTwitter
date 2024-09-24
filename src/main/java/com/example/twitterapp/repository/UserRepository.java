package com.example.twitterapp.repository;

import com.example.twitterapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by username
    User findByUsername(String username);

    // Save a user entity
    User save(User userDto);
}
