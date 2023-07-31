package com.example.hotelk.room.repository;

import com.example.hotelk.room.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Room findByFirstnameContaining(String name);

}
