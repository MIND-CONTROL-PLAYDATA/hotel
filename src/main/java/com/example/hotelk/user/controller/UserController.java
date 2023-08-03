package com.example.hotelk.user.controller;


import com.example.hotelk.security.TokenInfo;
import com.example.hotelk.user.domain.request.LoginRequest;
import com.example.hotelk.user.domain.request.SignupRequest;
import com.example.hotelk.user.domain.response.SignupResponse;
import com.example.hotelk.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest request) {
        SignupResponse signup = service.signup(request);
        return signup;
    }

    @PostMapping("/login")
    public TokenInfo login(@RequestBody LoginRequest request) {
        TokenInfo tokenInfo = service.login(request);
        return tokenInfo;
    }
}
