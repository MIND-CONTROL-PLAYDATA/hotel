package com.example.hotelk.global.repository;

import com.example.hotelk.global.domain.entity.FacilityUsage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityUsageRepository extends JpaRepository<FacilityUsage, Long> {
    Page<FacilityUsage> findAll(Pageable pageable);
}
