package com.example.hotelk.room.repository;

import com.example.hotelk.room.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByNameContaining(String name);

}
