package com.example.hotelk.global.controller;


import com.example.hotelk.global.domain.request.RegionRequest;
import com.example.hotelk.global.domain.response.RegionResponse;
import com.example.hotelk.global.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/region")
public class RegionController {

    private final RegionService regionService;

    @PostMapping
    public void insert(@RequestBody RegionRequest request) {
        regionService.insert(request);
    }

    @GetMapping
    public Page<RegionResponse> findAll(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return regionService.getAll(name, request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody RegionRequest request) {
        regionService.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) { regionService.delete(id);}

}
