package com.example.twitterapp.service;

import com.example.twitterapp.model.User;

public interface UserService {

    // Find a user by their username
    User findByUsername(String username);

    // Save a user entity
    User save(User userDto);
}
