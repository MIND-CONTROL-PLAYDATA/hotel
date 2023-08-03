package com.example.hotelk.global.repository;

import com.example.hotelk.global.domain.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Optional<Promotion> findByTitle(String Title);
}
