package com.example.hotelk.amenities.service;

import com.example.hotelk.amenities.domain.entity.Amenities;
import com.example.hotelk.amenities.domain.request.AmenitiesRequest;
import com.example.hotelk.amenities.domain.response.AmenitiesResponse;
import com.example.hotelk.amenities.repository.AmenitiesRepository;
import com.example.hotelk.config.exception.AmenitiesNotFoundException;
import com.example.hotelk.config.exception.HotelNotFoundException;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.repository.HotelRepository;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacility.domain.request.HotelFacilityRequest;
import com.example.hotelk.region.domain.RegionRequest;
import com.example.hotelk.region.domain.RegionResponse;
import com.example.hotelk.region.domain.entity.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AmenitiesService {

    private final AmenitiesRepository amenitiesRepository;
    private final HotelRepository hotelRepository;

    public void insert(AmenitiesRequest request) {
        Long hotelId = request.hotelId();

        // Find the Hotel entity from the database based on the provided hotelId
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        // Create the HotelFacility entity with the fetched Hotel entity
        Amenities hotelFacility = Amenities.builder()
                .hotel(hotel)
                .name(request.name())
                .description(request.description())
                .build();

        // Save the HotelFacility entity
        amenitiesRepository.save(hotelFacility);
    }

    public Page<AmenitiesResponse> getAll(String name, PageRequest request) {

        Page<Amenities> all = amenitiesRepository.findAllByNameContaining(name, request);
        return all.map(AmenitiesResponse::new);
    }


    public AmenitiesResponse update(Long id, AmenitiesRequest request) {
        Optional<Amenities> byId = amenitiesRepository.findById(id);
        if (byId.isEmpty()) throw new AmenitiesNotFoundException("AMENITIES NOT FOUND!!");

        Amenities amenities = new Amenities(id, request.name(), request.description(), byId.get().getHotel());
        Amenities save = amenitiesRepository.save(amenities);
        return new AmenitiesResponse(save);
    }



    public void delete(Long id) {
        amenitiesRepository.deleteById(id);
    }
}
