package com.example.hotelk.hotel.domain.repository;

import com.example.hotelk.hotel.domain.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Optional<Promotion> findByTitle(String Title);
}
