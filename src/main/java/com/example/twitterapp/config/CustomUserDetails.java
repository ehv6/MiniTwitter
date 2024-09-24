package com.example.twitterapp.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Custom implementation of Spring Security's UserDetails interface.
 * This class holds user-specific data for authentication and authorization.
 */
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Constructor to initialize the custom user details with username, password, and authorities.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param authorities the granted authorities for the user
     */
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * Returns the authorities granted to the user.
     *
     * @return a collection of granted authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password of the user
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user.
     *
     * @return the username of the user
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Indicates whether the user's account has expired. (Always returns true, meaning it's not expired).
     *
     * @return true (the account is not expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. (Always returns true, meaning the account is not locked).
     *
     * @return true (the account is not locked)
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials have expired. (Always returns true, meaning credentials are valid).
     *
     * @return true (the credentials are not expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. (Always returns true, meaning the user is enabled).
     *
     * @return true (the user is enabled)
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
