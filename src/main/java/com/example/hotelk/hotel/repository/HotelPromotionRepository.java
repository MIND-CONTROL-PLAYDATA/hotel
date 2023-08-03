package com.example.hotelk.hotel.repository;

import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelPromotionRepository extends JpaRepository<HotelPromotion, Long> {
    Page<HotelPromotion> findAll(Pageable pageable);

}
