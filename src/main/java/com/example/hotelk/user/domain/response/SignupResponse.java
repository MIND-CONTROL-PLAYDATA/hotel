package com.example.hotelk.user.domain.response;


import com.example.hotelk.user.domain.entity.User;
import lombok.Getter;

@Getter
public class SignupResponse {

    private Long userId;

    private String username;
    private String email;
    private String password;

    public SignupResponse(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
