package com.example.hotelk.user.serivce;


import com.example.hotelk.security.JwtTokenProvider;
import com.example.hotelk.security.TokenInfo;
import com.example.hotelk.user.domain.entity.User;
import com.example.hotelk.user.domain.request.LoginRequest;
import com.example.hotelk.user.domain.request.SignupRequest;
import com.example.hotelk.user.repository.UserRepository;
import com.example.hotelk.user.response.SignupResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
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
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }
}
