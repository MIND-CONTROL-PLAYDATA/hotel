package com.example.hotelk.review.service;

import com.example.hotelk.review.domain.entity.Review;
import com.example.hotelk.review.domain.request.ReviewRequest;
import com.example.hotelk.review.domain.response.ReviewResponse;
import com.example.hotelk.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;


    @Override
    public void save(ReviewRequest request) {
        repository.save(request.toEntity());
    }

    @Override
    public ReviewResponse changeDate(Long id, ReviewRequest request) {
        Optional<Review> byId = repository.findById(id);
        if (byId.isEmpty()) throw new RuntimeException("게시물이 없습니다.");
        Review review = new Review(id, null, request.getGuestName(), request.getRating(),
                request.getComment(), request.getCreatedAt(), request.getUserId());
        Review save = repository.save(review);
        return new ReviewResponse(save);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Review findById(Long id) {
        Optional<Review> byId = repository.findById(id);
        return byId.orElseThrow(()-> new RuntimeException("없는 review입니다."));
    }

    @Override
    public Page<ReviewResponse> findAll(Pageable pageable) {
        Page<Review> allBy = repository.findAll(pageable);
        return allBy.map(r-> new ReviewResponse(r));
    }
}
