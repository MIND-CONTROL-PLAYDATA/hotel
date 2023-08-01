package com.example.hotelk.roomImage.service;

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

    private final RoomImageRepository repository;
    @Override
    public void save(ImageRequest request) {
        repository.save(request.toEntity(request));
    }

    @Override
    public void update(Long id, ImageRequest request) {
        RoomImage roomImage = findById(id);
        roomImage.update(request);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public List<RoomImage> findAll() {
        return repository.findAll();
    }

    @Override
    public RoomImage findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
