package com.example.hotelk.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement(s-> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(h->
                h
                        .requestMatchers("/api/v1/user/test").permitAll()
                        .requestMatchers("/api/v1/region/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/hotel/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/hotel_region/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/user/**").permitAll()
                        .requestMatchers("/api/v1/reviews/**").hasRole("USER")
                        .requestMatchers("/api/v1/reservation/**").hasRole("USER")
                        .requestMatchers("/api/v1/hotelFacility/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/hotelFacilityUsage/**").hasRole("USER")
                        .requestMatchers("/api/v1/room/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/connect/**").hasRole("ADMIN")
                        .requestMatchers("/swagger-ui/**",
                                "/swagger-resources/*",
                                "/v3/api-docs/**")
                        .permitAll()
                        .anyRequest().authenticated()
                );
//        http
//                .httpBasic().disable()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/members/login").permitAll()
//                .antMatchers("/members/test").hasRole("USER")
//                .anyRequest().authenticated();
        http
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}