package com.example.hotelk.amenities.service;

import com.example.hotelk.amenities.domain.entity.Amenities;
import com.example.hotelk.amenities.domain.request.AmenitiesRequest;
import com.example.hotelk.amenities.domain.response.AmenitiesResponse;
import com.example.hotelk.amenities.repository.AmenitiesRepository;
import com.example.hotelk.region.domain.RegionResponse;
import com.example.hotelk.region.domain.entity.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AmenitiesService {

    private final AmenitiesRepository amenitiesRepository;

    public void insert(AmenitiesRequest request) {
        amenitiesRepository.save(request.toEntity());
    }

    public Page<AmenitiesResponse> getAll(String name, PageRequest request) {

        Page<Amenities> all = amenitiesRepository.findAllByNameContaining(name, request);
        return all.map(AmenitiesResponse::new);
    }

    public AmenitiesResponse update(Long id, AmenitiesRequest request) {
        Optional<Amenities> byId = amenitiesRepository.findById(id);
        Amenities amenities = byId.orElseThrow(() -> new RuntimeException("AMENITIES NOT FOUND!!"));
        Amenities save = amenitiesRepository.save(amenities);
        return new AmenitiesResponse(save);
    }

    public void delete(Long id) {
        amenitiesRepository.deleteById(id);
    }
}
