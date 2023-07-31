package com.example.hotelk.user.service;

import com.example.hotelk.user.domain.dto.UserDto;
import com.example.hotelk.user.domain.entity.Role;
import com.example.hotelk.user.domain.entity.User;
import com.example.hotelk.user.repository.RoleRepository;
import com.example.hotelk.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

}
