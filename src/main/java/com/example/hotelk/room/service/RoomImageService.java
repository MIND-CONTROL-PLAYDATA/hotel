package com.example.hotelk.room.service;

import com.example.hotelk.room.domain.entity.RoomImage;
import com.example.hotelk.room.domain.requset.ImageRequest;

import java.util.List;

public interface RoomImageService {
    void save(Long roomId, ImageRequest request);

    void update(Long roomId, Long id, ImageRequest request);

    void delete(Long id);

    List<RoomImage> findAll(Long roomId);

    RoomImage findById(Long id);
}
