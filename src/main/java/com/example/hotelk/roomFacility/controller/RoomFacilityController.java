package com.example.hotelk.roomFacility.controller;

import com.example.hotelk.roomFacility.domain.entity.RoomFacility;
import com.example.hotelk.roomFacility.domain.request.RoomFacilityRequest;
import com.example.hotelk.roomFacility.serivce.RoomFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/facility")
public class RoomFacilityController {
    private final RoomFacilityService service;
    @PostMapping
    public void save(@RequestBody RoomFacilityRequest request){
        service.save(request);
    }

    @GetMapping("{name}")
    public RoomFacility findByName(@PathVariable String name){
        return service.findByName(name);
    }

    @GetMapping
    public List<RoomFacility> findAll(){
        return service.findAll();
    }

    @PutMapping("{name}")
    public void update(@PathVariable String name,
                       @RequestBody RoomFacilityRequest request){
        service.update(name, request);
    }

    @DeleteMapping("{name}")
    public void delete(@PathVariable String name){
        service.delete(name);
    }
}
