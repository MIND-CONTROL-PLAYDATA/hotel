package com.example.hotelk.hotel.domain.repository;

import com.example.hotelk.hotel.domain.entity.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {
}
