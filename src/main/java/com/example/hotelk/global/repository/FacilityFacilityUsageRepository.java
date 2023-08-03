package com.example.hotelk.global.repository;

import com.example.hotelk.global.domain.entity.FacilityFacilityUsage;
import com.example.hotelk.global.domain.request.FacilityFacilityUsageRequest;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityFacilityUsageRepository extends JpaRepository<FacilityFacilityUsage, Long> {
    Page<FacilityFacilityUsage> findAll(Pageable pageable);
}
