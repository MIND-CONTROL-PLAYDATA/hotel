package com.example.hotelk.user.service;


import com.example.hotelk.security.JwtTokenProvider;
import com.example.hotelk.security.TokenInfo;
import com.example.hotelk.user.domain.entity.User;
import com.example.hotelk.user.domain.request.LoginRequest;
import com.example.hotelk.user.domain.request.SignupRequest;
import com.example.hotelk.user.repository.UserRepository;
import com.example.hotelk.user.domain.response.SignupResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder bCryptPasswordEncoder;

    public SignupResponse signup(SignupRequest request) throws Exception {
        if(this.isEmailExist(request.email())) {
            throw new Exception("Your Mail already Exist.");
        }
        User user = request.toEntity();
        user.hashPassword(bCryptPasswordEncoder);
        User save = userRepository.save(user);
        return new SignupResponse(save);
    }
    private boolean isEmailExist(String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        return !byEmail.isEmpty();
    }
    @Transactional
    public TokenInfo login(LoginRequest request) {
        // 1. Get the user by username (or email) from the database
        Optional<User> byUsername = userRepository.findByUsername(request.username());
        User user = byUsername.orElseThrow(() -> new RuntimeException("USER NOT FOUND"));

        // 2. Check the provided plain-text password against the hashed password
        if (bCryptPasswordEncoder.matches(request.password(), user.getPassword())) {
            // 3. Authenticate the user
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 4. Generate JWT token
            TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
            return tokenInfo;
        } else {
            throw new RuntimeException("Invalid username/password");
        }
    }
}
