package com.example.hotelk.hotel.repository;

import com.example.hotelk.global.domain.entity.Facility;
import com.example.hotelk.hotel.domain.entity.HotelFacility;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelFacilityRepository extends JpaRepository<HotelFacility, Long> {
    Page<HotelFacility> findAll(Pageable pageable);
}
