package com.example.hotelk.hotelRegion.repository;

import com.example.hotelk.hotelRegion.domain.entity.HotelRegion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRegionRepository extends JpaRepository<HotelRegion, Long> {

    Page<HotelRegion> findAll(Pageable pageable);
}
