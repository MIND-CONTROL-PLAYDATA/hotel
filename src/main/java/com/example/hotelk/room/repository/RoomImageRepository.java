package com.example.hotelk.room.repository;

import com.example.hotelk.room.domain.entity.RoomImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomImageRepository extends JpaRepository<RoomImage,Long> {
    @Query("select rf from RoomImage rf where rf.room.roomId= :roomId")
    List<RoomImage> findAll(Long roomId);

    @Query("select rf from RoomImage rf where rf.room.roomId= :roomId and rf.imageId= :id")
    RoomImage findByRoomIdAndImageId(Long roomId, Long id);
}
