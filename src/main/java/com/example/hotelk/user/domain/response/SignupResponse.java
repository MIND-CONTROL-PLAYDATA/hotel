package com.example.hotelk.user.domain.response;


import com.example.hotelk.user.domain.entity.User;
import lombok.Getter;

import java.util.List;

@Getter
public class SignupResponse {

    private Long userId;
    private String email;
    private String username;

    List<String> roles;


    public SignupResponse(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.roles = user.getRoles();
    }
}
