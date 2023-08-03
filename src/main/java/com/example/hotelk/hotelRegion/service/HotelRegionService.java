package com.example.hotelk.hotelRegion.service;

import com.example.hotelk.config.exception.HotelNotFoundException;
import com.example.hotelk.config.exception.RegionNotFoundException;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.repository.HotelRepository;
import com.example.hotelk.hotelRegion.domain.entity.HotelRegion;
import com.example.hotelk.hotelRegion.domain.request.ConnectRequest;
import com.example.hotelk.hotelRegion.domain.response.HotelRegionResponse;
import com.example.hotelk.hotelRegion.repository.HotelRegionRepository;
import com.example.hotelk.region.domain.RegionRequest;
import com.example.hotelk.region.domain.RegionResponse;
import com.example.hotelk.region.domain.entity.Region;
import com.example.hotelk.region.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelRegionService {

    private final HotelRegionRepository hotelRegionRepository;
    private final HotelRepository hotelRepository;
    private  final RegionRepository regionRepository;

    @Transactional
    public void connect(ConnectRequest request) {
        HotelRegion hotelRegion = new HotelRegion(null,
                Hotel.builder().hotelId(request.hotelId()).build(),
                Region.builder().regionId(request.regionId()).build()
        );
        hotelRegionRepository.save(hotelRegion);

    }

    public Page<HotelRegionResponse> getAll(PageRequest request) {

        Page<HotelRegion> all = hotelRegionRepository.findAll(request);
        return all.map(HotelRegionResponse::new);
    }


    @Transactional
    public HotelRegionResponse update(Long id, ConnectRequest request) {
        Optional<HotelRegion> byId = hotelRegionRepository.findById(id);
        if (byId.isEmpty()) throw new RegionNotFoundException("REGION NOT FOUND!!");

        Optional<Hotel> byId1 = hotelRepository.findById(request.hotelId());
        Optional<Region> byId2 = regionRepository.findById(request.regionId());

        Hotel hotel = byId1.orElseThrow(() -> new HotelNotFoundException("HOTEL NOT FOUND!!"));
        Region region = byId2.orElseThrow(() -> new RegionNotFoundException("REGION NOT FOUND!!"));

        HotelRegion hotelRegion = new HotelRegion(id, hotel, region);
        HotelRegion save = hotelRegionRepository.save(hotelRegion);

        return new HotelRegionResponse(save);
    }

    public void delete(Long id) {
        hotelRegionRepository.deleteById(id);
    }
}
