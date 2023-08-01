package com.example.hotelk.roomImage.service;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.repository.RoomRepository;
import com.example.hotelk.roomImage.domain.entity.RoomImage;
import com.example.hotelk.roomImage.domain.request.ImageRequest;
import com.example.hotelk.roomImage.repository.RoomImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
@RequiredArgsConstructor
public class RoomImageServiceImpl implements RoomImageService{

    private final RoomImageRepository roomImageRepository;
    private final RoomRepository roomRepository;
    @Override
    public void save(Long roomId,ImageRequest request) {
        Room room = roomRepository.findById(roomId).orElseThrow();
        roomImageRepository.save(request.toEntity(request,room));
    }

    @Override
    public void update(Long id, ImageRequest request) {
        RoomImage roomImage = findById(id);
        roomImage.update(request);
    }

    @Override
    public void delete(Long id) {
        roomImageRepository.delete(findById(id));
    }

    @Override
    public List<RoomImage> findAll() {
        return roomImageRepository.findAll();
    }

    @Override
    public RoomImage findById(Long id) {
        return roomImageRepository.findById(id).orElseThrow();
    }
}
