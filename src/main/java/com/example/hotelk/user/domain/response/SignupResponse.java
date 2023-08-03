package com.example.hotelk.user.domain.response;


import com.example.hotelk.user.domain.entity.User;
import lombok.Getter;

@Getter
public class SignupResponse {

    private Long userId;
    private String email;
    private String username;


    public SignupResponse(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
