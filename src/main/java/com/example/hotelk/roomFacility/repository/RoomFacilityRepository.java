package com.example.hotelk.roomFacility.repository;

import com.example.hotelk.roomFacility.domain.entity.RoomFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomFacilityRepository extends JpaRepository<RoomFacility,Long> {
   RoomFacility findByNameContaining(String name);
}
