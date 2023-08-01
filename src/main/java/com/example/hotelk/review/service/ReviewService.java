package com.example.hotelk.review.service;

import com.example.hotelk.review.domain.entity.Review;
import com.example.hotelk.review.domain.request.ReviewRequest;
import com.example.hotelk.review.domain.response.ReviewResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewService {

    void save(ReviewRequest request);
    ReviewResponse changeDate(Long id, ReviewRequest request);
    void deleteById(Long id);
    Review findById(Long id);
    Page<ReviewResponse> findAll(Pageable pageable);



}
