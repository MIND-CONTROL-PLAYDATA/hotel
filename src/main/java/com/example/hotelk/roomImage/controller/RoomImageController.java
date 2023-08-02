package com.example.hotelk.roomImage.controller;

import com.example.hotelk.room.repository.RoomRepository;
import com.example.hotelk.roomImage.domain.entity.RoomImage;
import com.example.hotelk.roomImage.domain.request.ImageRequest;
import com.example.hotelk.roomImage.service.RoomImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/{roomId}/roomImage")
@RequiredArgsConstructor
public class RoomImageController {
    private final RoomImageService service;

    @PostMapping
    public void save(@PathVariable Long roomId,
                     @RequestBody ImageRequest request){
        service.save(roomId,request);
    }

    @GetMapping
    public List<RoomImage> findAllImage(@PathVariable Long roomId){
        return service.findAll(roomId);
    }

    @PutMapping("{id}")
    public void updateImage(@PathVariable Long roomId,
                            @PathVariable Long id,
                            @RequestBody ImageRequest request){
        service.update(roomId,id,request);
    }

    @DeleteMapping("{id}")
    public void deleteImage(@PathVariable Long id){
        service.delete(id);
    }

}
