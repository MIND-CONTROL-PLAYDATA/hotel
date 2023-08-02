package com.example.hotelk.hotel.domain.repository;

import com.example.hotelk.hotel.domain.entity.HotelRegion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRegionRepository extends JpaRepository<HotelRegion, Long> {

    Page<HotelRegion> findAll(Pageable pageable);
}
