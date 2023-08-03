package com.example.hotelk.global.repository;

import com.example.hotelk.global.domain.entity.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
    Page<Facility> findAllByNameContaining(String name, Pageable pageable);
}
