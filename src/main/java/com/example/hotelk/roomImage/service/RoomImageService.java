package com.example.hotelk.roomImage.service;

import com.example.hotelk.roomImage.domain.entity.RoomImage;
import com.example.hotelk.roomImage.domain.request.ImageRequest;

import java.util.List;

public interface RoomImageService {
    void save(Long roomId, ImageRequest request);

    void update(Long roomId, Long id, ImageRequest request);

    void delete(Long id);

    List<RoomImage> findAll(Long roomId);

    RoomImage findById(Long id);
}
