package com.example.twitterapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Injecting CustomUserDetailsService to retrieve user-specific information
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    // BCryptPasswordEncoder bean to encrypt passwords using BCrypt
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // SecurityFilterChain bean handles overall security configurations
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF (Cross-Site Request Forgery) for simplicity (be careful in production)
                .csrf(csrf -> csrf.disable())

                // Define which pages are accessible to everyone (permitAll) and which require authentication
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/register", "/home", "/h2-console/**", "/images/**").permitAll()
                        .anyRequest().authenticated() // All other requests must be authenticated
                )

                // Configure form-based login
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .loginProcessingUrl("/login") // URL to submit the login form
                        .defaultSuccessUrl("/", true) // Redirect to home on successful login
                        .permitAll() // Allow access to login page without authentication
                )

                // Configure logout functionality
                .logout(logout -> logout
                        .invalidateHttpSession(true) // Invalidate session on logout
                        .clearAuthentication(true) // Clear authentication on logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // URL to trigger logout
                        .logoutSuccessUrl("/login?logout") // Redirect to login page with a logout message
                        .permitAll() // Allow anyone to access the logout URL
                )

                // This enables the H2 database console to be accessed without X-Frame-Options blocking it
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin())
                );

        return http.build();
    }

    // CustomUserDetailsService configuration with password encoder
    // Deprecated method using AuthenticationManagerBuilder: not needed with new configurations
    // Recommend refactoring this method out.
}
