package com.example.hotelk.roomFacility.serivce;

import com.example.hotelk.roomFacility.domain.entity.RoomFacility;
import com.example.hotelk.roomFacility.domain.request.RoomFacilityRequest;
import com.example.hotelk.roomFacility.repository.RoomFacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
@RequiredArgsConstructor
public class RoomFacilityServiceImpl implements RoomFacilityService {
    private final RoomFacilityRepository repository;
    @Override
    public void save(RoomFacilityRequest request) {//예외처리하기(같은거)
        repository.save(request.toEntity(request));
    }

    @Override
    public RoomFacility findByName(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public void delete(String name) {
        repository.delete(findByName(name));
    }

    @Override
    public void update(String name, RoomFacilityRequest request) {
        RoomFacility roomFacility = findByName(name);
        roomFacility.update(request);
    }

    @Override
    public List<RoomFacility> findAll() {
        return repository.findAll();
    }

}
