package com.example.hotelk.review.domain.request;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.review.domain.entity.Review;
import com.example.hotelk.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class ReviewRequest {
    private Hotel hotelId;
    private String guestName;
    private Double rating;
    private String comment;
    private LocalDateTime createdAt;
    private User userId;

    public Review toEntity() {
        createdAt = LocalDateTime.now();
        return Review.builder()
                .hotel(hotelId)
                .guestName(guestName)
                .rating(rating)
                .comment(comment)
                .createdAt(createdAt)
                .user(userId)
                .build();
    }
}
