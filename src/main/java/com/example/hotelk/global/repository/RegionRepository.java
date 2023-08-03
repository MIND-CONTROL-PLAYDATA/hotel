package com.example.hotelk.global.repository;

import com.example.hotelk.global.domain.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Page<Region> findAllByNameContaining(String name, Pageable pageable);
}
