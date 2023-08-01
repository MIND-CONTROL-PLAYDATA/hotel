package com.example.hotelk.hotelFacilityUsage.repository;

import com.example.hotelk.hotelFacilityUsage.domain.entity.HotelFacilityUsage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelFacilityUsageRepository extends JpaRepository<HotelFacilityUsage, Long> {
    Page<HotelFacilityUsage> findAll(Pageable pageable);
}
