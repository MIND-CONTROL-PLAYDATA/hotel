package com.example.hotelk.room.controller;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.domain.requset.RoomRequest;
import com.example.hotelk.room.domain.requset.UpdateRequest;
import com.example.hotelk.room.domain.response.RoomResponse;
import com.example.hotelk.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RoomController {
    private final RoomService roomService;

    @PostMapping("{hotelId}/room")
    public void save(@PathVariable Long hotelId,
                     @RequestBody RoomRequest request){
        roomService.insert(hotelId,request);
    }

    @GetMapping("{hotelId}/room")
    public List<RoomResponse> findAll(@PathVariable Long hotelId){
        return roomService.findAll(hotelId);
    }

    @GetMapping("{name}")
    public List<RoomResponse> findByName(@PathVariable String name){
        return roomService.findByName(name);
    }

    @DeleteMapping("{id}")
    public void deleteRoom(@PathVariable Long id){
        roomService.delete(id);
    }

    @PatchMapping("{id}")
    public void updateRoom(@PathVariable Long id
    , @RequestBody UpdateRequest request){
        roomService.update(id,request);
    }
}
