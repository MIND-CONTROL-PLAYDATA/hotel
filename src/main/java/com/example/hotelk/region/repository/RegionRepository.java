package com.example.hotelk.region.repository;

import com.example.hotelk.region.domain.RegionResponse;
import com.example.hotelk.region.domain.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Page<Region> findAllByNameContaining(String name, Pageable pageable);
}
