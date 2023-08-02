package com.example.hotelk.region.service;

import com.example.hotelk.region.domain.RegionRequest;
import com.example.hotelk.region.domain.RegionResponse;
import com.example.hotelk.region.domain.entity.Region;
import com.example.hotelk.region.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    @Transactional
    public void insert(RegionRequest request) {
        regionRepository.save(request.toEntity());
    }

    public Page<RegionResponse> getAll(String name, PageRequest request) {

        Page<Region> all = regionRepository.findAllByNameContaining(name, request);
        return all.map(RegionResponse::new);
    }

    @Transactional
    public RegionResponse update(Long id, RegionRequest request) {
        Optional<Region> byId = regionRepository.findById(id);
        if (byId.isEmpty()) throw new RuntimeException("REGION NOT FOUND!!");
        Region region = new Region(id, request.name(), null);
        Region save = regionRepository.save(region);

        return new RegionResponse(save);
    }

    public void delete(Long id) {
        regionRepository.deleteById(id);
    }
}
