package com.example.hotelk.user.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long userId;

    private String username;
    private String email;
    private String password;
    private List<String> roles;
}
