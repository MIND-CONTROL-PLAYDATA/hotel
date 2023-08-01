package com.example.hotelk.room.controller;

import com.example.hotelk.room.domain.entity.Room;
import com.example.hotelk.room.domain.requset.RoomRequest;
import com.example.hotelk.room.domain.requset.UpdateRequest;
import com.example.hotelk.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/room")
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public void save(@RequestBody RoomRequest request){
        roomService.insert(request);
    }

    @GetMapping
    public List<Room> findAll(){
        return roomService.findAll();
    }

    @GetMapping("{name}")
    public List<Room> findByName(@PathVariable String name){
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
