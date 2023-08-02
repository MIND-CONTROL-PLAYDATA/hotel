package com.example.hotelk.hotel.domain.repository;

import com.example.hotelk.hotel.domain.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Page<Hotel> findAll(Pageable pageable);
    Page<Hotel> findByName(String name, Pageable pageable);
    Page<Hotel> findByAddress(String Address, Pageable pageable);
}
