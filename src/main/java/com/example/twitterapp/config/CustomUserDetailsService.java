package com.example.twitterapp.config;

import com.example.twitterapp.model.User;
import com.example.twitterapp.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // Constructor-based dependency injection for UserRepository
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to load user details by username for authentication
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find user in the repository by username
        User user = userRepository.findByUsername(username);

        // If user not found, throw exception
        if (user == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }

        // Return user details with authorities for Spring Security
        return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities());
    }

    // Method to define user authorities, assigning a "USER" role
    public Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }
}
