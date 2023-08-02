package com.example.hotelk.hotel.controller;

import com.example.hotelk.hotel.domain.entity.Promotion;
import com.example.hotelk.hotel.domain.request.HotelPromotionRequest;
import com.example.hotelk.hotel.domain.request.PromotionRequest;
import com.example.hotelk.hotel.domain.response.PromotionResponse;
import com.example.hotelk.hotel.service.HotelPromotionService;
import com.example.hotelk.hotel.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    @PostMapping
    public void insert(@RequestBody PromotionRequest promotionRequest) {
        promotionService.insert(promotionRequest);
    }

    @GetMapping
    public List<PromotionResponse> getAll() {
        return promotionService.findAll();
    }
    @GetMapping("/findByTitle")
    public Optional<Promotion> findByTitle(@RequestParam(value = "title", required = false, defaultValue = "")String title ) {
        return promotionService.findByTitle(title);
    }
    @PutMapping("{promotionId}")
    public void update(@PathVariable("promotionId") Long promotionId,
                       @RequestBody PromotionRequest promotionRequest) {
        promotionService.update(promotionId, promotionRequest);
    }
    @DeleteMapping
    public void delete(@PathVariable("{promotionId")Long promotionId){
        promotionService.delete(promotionId);
    }
}
