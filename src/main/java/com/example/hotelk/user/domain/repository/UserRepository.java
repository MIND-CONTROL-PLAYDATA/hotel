package com.example.hotelk.user.domain.repository;

import com.example.hotelk.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    @Query("select u from User  u where u.username = :username")
    User findByUsername(@Param("username") String username);
}
