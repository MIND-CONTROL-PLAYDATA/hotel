package com.example.hotelk.user.service;


import com.example.hotelk.user.domain.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void save(UserDto userDto);

    UserDto findByUsername(String username);
}
