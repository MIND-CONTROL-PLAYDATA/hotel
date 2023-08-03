package com.example.hotelk.user.service;


import com.example.hotelk.config.exception.ExistEmailException;
import com.example.hotelk.config.exception.LoginFailException;
import com.example.hotelk.security.JwtTokenProvider;
import com.example.hotelk.security.TokenInfo;
import com.example.hotelk.user.domain.entity.User;
import com.example.hotelk.user.domain.request.LoginRequest;
import com.example.hotelk.user.domain.request.SignupRequest;
import com.example.hotelk.user.repository.UserRepository;
import com.example.hotelk.user.domain.response.SignupResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder bCryptPasswordEncoder;

    public SignupResponse signup(SignupRequest request)  {
        if(this.isEmailExist(request.email())) {
            throw new ExistEmailException("Your Mail already Exist.");
        }
        User user = request.toEntity();
        user.setRoles(request.roles());
        user.hashPassword(bCryptPasswordEncoder);
        User save = userRepository.save(user);
        return new SignupResponse(save);
    }
    private boolean isEmailExist(String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        return byEmail.isPresent();
    }
    @Transactional
    public TokenInfo login(LoginRequest request) {

        Optional<User> byEmail = userRepository.findByEmail(request.email());
        User user = byEmail.orElseThrow(() -> new LoginFailException("USER NOT FOUND"));


        if (bCryptPasswordEncoder.matches(request.password(), user.getPassword())) {

            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
            return tokenInfo;
        } else {
            throw new LoginFailException("Invalid email/password");
        }
    }
}
