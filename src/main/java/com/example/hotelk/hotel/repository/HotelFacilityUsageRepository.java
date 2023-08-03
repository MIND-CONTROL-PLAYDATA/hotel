package com.example.hotelk.hotel.repository;

import com.example.hotelk.global.domain.entity.Facility;
import com.example.hotelk.global.domain.entity.FacilityUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelFacilityUsageRepository extends JpaRepository<FacilityUsage, Long> {
}
