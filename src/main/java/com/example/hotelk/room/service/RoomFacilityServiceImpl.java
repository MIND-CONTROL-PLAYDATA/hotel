package com.example.hotelk.room.service;

import com.example.hotelk.config.exception.ExistFacilityException;
import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.repository.RoomRepository;
import com.example.hotelk.room.domain.entity.RoomFacility;
import com.example.hotelk.room.domain.requset.RoomFacilityRequest;
import com.example.hotelk.room.domain.response.RoomFacilityResponse;
import com.example.hotelk.room.repository.RoomFacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
@RequiredArgsConstructor
public class RoomFacilityServiceImpl implements RoomFacilityService {
    private final RoomFacilityRepository repository;
    private final RoomRepository roomRepository;
    @Override
    public void save(Long roomId, RoomFacilityRequest request) {//예외처리하기(같은거)
        Optional<RoomFacility> roomFacility = repository.whereName(request.getName(), roomId);
        if(roomFacility.isPresent()){
            throw new ExistFacilityException("이미 등록된 제품 입니다.");
        }
        else {
            Room room = roomRepository.findById(roomId).orElseThrow();
            repository.save(request.toEntity(request, room));
        }
    }

    @Override
    public void delete(Long roomId, String name) {
        RoomFacility roomFacility = repository.whereName(name, roomId).orElseThrow();
        repository.delete(roomFacility);
    }

    @Override
    public void update(Long roomId, String name, RoomFacilityRequest request) {
        RoomFacility roomFacility = repository.whereName(name, roomId).orElseThrow();
        roomFacility.update(request);
    }

    @Override
    public List<RoomFacilityResponse> findAll(Long roomId) {
        List<RoomFacility> all = repository.findAll(roomId);
        return all
                .stream()
                .map(RoomFacilityResponse::new)
                .toList();
    }

    @Override
    public RoomFacilityResponse findByName(Long roomId, String name) {
        RoomFacility roomFacility = repository.whereName(name,roomId).orElseThrow();
        return new RoomFacilityResponse(roomFacility);
    }

}
