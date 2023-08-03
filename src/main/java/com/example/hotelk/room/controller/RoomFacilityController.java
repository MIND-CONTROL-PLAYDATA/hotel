package com.example.hotelk.room.controller;

import com.example.hotelk.room.domain.requset.RoomFacilityRequest;
import com.example.hotelk.room.domain.response.RoomFacilityResponse;
import com.example.hotelk.room.service.RoomFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/{roomId}/facility")
public class RoomFacilityController {
    private final RoomFacilityService service;

    @PostMapping
    public void save(@PathVariable Long roomId,
                     @RequestBody RoomFacilityRequest request) {
        service.save(roomId, request);
    }

    @GetMapping("{name}")
    public RoomFacilityResponse findByName(@PathVariable Long roomId,
                                   @PathVariable String name) {
        return service.findByName(roomId, name);
    }

    @GetMapping
    public List<RoomFacilityResponse> findAll(@PathVariable Long roomId) {
        return service.findAll(roomId);
    }

    @PutMapping("{name}")
    public void update(@PathVariable Long roomId,
                       @PathVariable String name,
                       @RequestBody RoomFacilityRequest request) {
        service.update(roomId, name, request);
    }

    @DeleteMapping("{name}")
    public void delete(@PathVariable Long roomId,
                       @PathVariable String name) {
        service.delete(roomId, name);
    }
}
