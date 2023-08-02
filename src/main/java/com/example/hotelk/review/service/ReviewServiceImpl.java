package com.example.hotelk.review.service;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.repository.HotelRepository;
import com.example.hotelk.review.domain.entity.Review;
import com.example.hotelk.review.domain.request.ReviewRequest;
import com.example.hotelk.review.domain.response.ReviewResponse;
import com.example.hotelk.review.repository.ReviewRepository;
import com.example.hotelk.user.domain.entity.User;
import com.example.hotelk.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;



    @Override
    public void save(ReviewRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));

        Hotel hotel = hotelRepository.findById(request.getHotelId())
                .orElseThrow(()-> new RuntimeException("Hotel not found"));

        Review review = Review.builder()
                .hotel(hotel)
                .guestName(request.getGuestName())
                .rating(request.getRating())
                .comment(request.getComment())
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();

        reviewRepository.save(review);
    }

    @Override
    public ReviewResponse changeDate(Long id, ReviewRequest request) {
        Optional<Review> byId = reviewRepository.findById(id);
        if (byId.isEmpty()) throw new RuntimeException("게시물이 없습니다.");

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));

        Review review = new Review(id, hotel, request.getGuestName(), request.getRating(),
                request.getComment(), request.getCreatedAt(), user);
        Review save = reviewRepository.save(review);
        return new ReviewResponse(save);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review findById(Long id) {
        Optional<Review> byId = reviewRepository.findById(id);
        return byId.orElseThrow(()-> new RuntimeException("없는 review입니다."));
    }

    @Override
    public Page<ReviewResponse> findAll(Pageable pageable) {
        Page<Review> allBy = reviewRepository.findAll(pageable);
        return allBy.map(r-> new ReviewResponse(r));
    }
}
