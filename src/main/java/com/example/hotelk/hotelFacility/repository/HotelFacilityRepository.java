package com.example.hotelk.hotelFacility.repository;

import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelFacilityRepository extends JpaRepository<HotelFacility, Long> {
    Page<HotelFacility> findAllByNameContaining(String name, Pageable pageable);
}
