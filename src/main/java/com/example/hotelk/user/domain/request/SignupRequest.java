package com.example.hotelk.user.domain.request;

import com.example.hotelk.user.domain.entity.User;

import java.util.List;

public record SignupRequest(String email, String username, String password, List<String> roles) {

    public User toEntity() {
        return User.builder().email(email).username(username).password(password).roles(roles).build();
    }
}
