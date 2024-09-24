package com.example.twitterapp.service;

import com.example.twitterapp.model.User;
import com.example.twitterapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    // Constructor-based injection for UserRepository
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User userDto) {
        // Encrypt the user's password before saving
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }
}
