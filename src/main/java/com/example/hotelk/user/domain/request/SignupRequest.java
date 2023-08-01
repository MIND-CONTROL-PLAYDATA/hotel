package com.example.hotelk.user.domain.request;

import com.example.hotelk.user.domain.entity.User;

public record SignupRequest(String email, String username, String password) {

    public User toEntity() {
        return User.builder().email(email).username(username).password(password).build();
    }
}
