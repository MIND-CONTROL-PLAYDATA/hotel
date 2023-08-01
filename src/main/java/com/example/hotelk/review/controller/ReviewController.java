package com.example.hotelk.review.controller;

import com.example.hotelk.review.domain.entity.Review;
import com.example.hotelk.review.domain.request.ReviewRequest;
import com.example.hotelk.review.domain.response.ReviewResponse;
import com.example.hotelk.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public void insert(@RequestBody ReviewRequest request) {
        reviewService.save(request);
    }

    @GetMapping("{id}")
    public Review getById(@PathVariable("id") Long id) {
        return reviewService.findById(id);
    }

    @GetMapping
    public Page<ReviewResponse> findAll(@RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                          @RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        PageRequest request = PageRequest.of(page, size);
        return reviewService.findAll(request);
    }

    @PutMapping("{id}")
    public void changeData(@PathVariable("id") Long id,
                           @RequestBody ReviewRequest request) {
        reviewService.changeDate(id, request);
    }
}
