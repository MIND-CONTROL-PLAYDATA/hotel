package com.example.hotelk.amenities.repository;

import com.example.hotelk.amenities.domain.entity.Amenities;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenitiesRepository extends JpaRepository<Amenities, Long> {

    Page<Amenities> findAllByNameContaining(String name, Pageable pageable);
}
