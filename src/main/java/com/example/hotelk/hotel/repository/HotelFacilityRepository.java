package com.example.hotelk.hotel.repository;

import com.example.hotelk.global.domain.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelFacilityRepository extends JpaRepository<Facility, Long> {
}
