package com.example.hotelk.user.controller;


import com.example.hotelk.security.TokenInfo;
import com.example.hotelk.user.domain.request.LoginRequest;
import com.example.hotelk.user.domain.request.SignupRequest;
import com.example.hotelk.user.domain.response.SignupResponse;
import com.example.hotelk.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest request) throws Exception {
        SignupResponse signup = service.signup(request);
        return signup;
    }

    @PostMapping("/login")
    public TokenInfo login(@RequestBody LoginRequest request) {
        TokenInfo tokenInfo = service.login(request);
        return tokenInfo;
    }
}
