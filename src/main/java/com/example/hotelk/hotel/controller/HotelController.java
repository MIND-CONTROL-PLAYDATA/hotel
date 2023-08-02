package com.example.hotelk.hotel.controller;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.request.HotelRequest;
import com.example.hotelk.hotel.domain.response.HotelResponse;
import com.example.hotelk.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel")
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public void insert(@RequestBody HotelRequest hotelRequest) {
        hotelService.save(hotelRequest);
    }
    @GetMapping
    public Page<HotelResponse> findHotelAll(@RequestParam(name="size", required = false, defaultValue = "12")Integer size,
                                              @RequestParam(name="page", required = false, defaultValue = "0")Integer page) {
        PageRequest request = PageRequest.of(page, size);
        return hotelService.getAll(request);
    }
    @GetMapping("/findByName")
    public Page<HotelResponse> findByName(@RequestParam(value = "name" , required = false, defaultValue = "")String name,
                                    @RequestParam(name="size", required = false, defaultValue = "12")Integer size,
                                    @RequestParam(name="page", required = false, defaultValue = "0")Integer page) {
        PageRequest request = PageRequest.of(page, size);
        return hotelService.findByName(name,request);
    }
    @GetMapping("/findByAddress")
    public Page<HotelResponse> findByAddress(@RequestParam(value = "address" , required = false, defaultValue = "")String address,
                                          @RequestParam(name="size", required = false, defaultValue = "12")Integer size,
                                          @RequestParam(name="page", required = false, defaultValue = "0")Integer page) {
        PageRequest request = PageRequest.of(page, size);
        return hotelService.findByAddress(address,request);
    }
    @PutMapping("{hotelId}")
    public void update(@PathVariable("hotelId")Long hotelId,
                       @RequestBody HotelRequest hotelRequest) {
        hotelService.update(hotelId, hotelRequest);

    }
    @DeleteMapping("{hotelId}")
    public void delete(@PathVariable("hotelId")Long hotelId){
        hotelService.delete(hotelId);
    }
}
