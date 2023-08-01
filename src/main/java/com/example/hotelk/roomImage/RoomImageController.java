package com.example.hotelk.roomImage;

import com.example.hotelk.roomImage.domain.entity.RoomImage;
import com.example.hotelk.roomImage.domain.request.ImageRequest;
import com.example.hotelk.roomImage.service.RoomImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roomImage")
public class RoomImageController {

    private final RoomImageService service;

    @GetMapping
    public List<RoomImage> findAllImage(){
        return service.findAll();
    }

    @PostMapping
    public void saveImage(@RequestBody ImageRequest request){
        service.save(request);
    }

    @PutMapping("{id}")
    public void updateImage(@PathVariable Long id,
                            @RequestBody ImageRequest request){
        service.update(id,request);
    }

    @DeleteMapping("{id}")
    public void deleteImage(@PathVariable Long id){
        service.delete(id);
    }


}
