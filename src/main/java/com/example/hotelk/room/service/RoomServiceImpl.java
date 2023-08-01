package com.example.hotelk.room.service;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.domain.requset.RoomRequest;
import com.example.hotelk.room.domain.requset.UpdateRequest;
import com.example.hotelk.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public void insert(RoomRequest request) {
        roomRepository.save(request.toEntity(request));
    }

    @Override
    public void delete(Long id) {
        roomRepository.delete(findById(id));
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow();   //예외처리하기
    }

    @Override
    public void update(Long id, UpdateRequest request) {
        Room room = roomRepository.findById(id).orElseThrow();
        room.update(request);
//        roomRepository.save(update);

    }

    @Override
    public List<Room> findByName(String name) {
        return roomRepository.findByNameContaining(name);

    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
