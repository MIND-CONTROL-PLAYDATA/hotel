package com.example.hotelk.room.repository;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.domain.entity.RoomFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomFacilityRepository extends JpaRepository<RoomFacility,Long> {
   RoomFacility findByRoomAndNameContaining(Room room, String name);

   @Query("select rf from RoomFacility rf where rf.name = :name and rf.room.roomId= :roomId")
   RoomFacility whereName(String name,Long roomId);

   @Query("select rf from RoomFacility rf where rf.room.roomId= :roomId ")
   List<RoomFacility> findAll(Long roomId);
}
