package com.example.hotelk.review.domain.request;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.review.domain.entity.Review;
import com.example.hotelk.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
@Getter
@AllArgsConstructor
public class ReviewRequest {
    private Long hotelId;
    private String guestName;
    private Double rating;
    private String comment;
    private Timestamp createdAt;
    private User userId;

    public Review toEntity() {
        return Review.builder()
                .hotel(new Hotel(hotelId,null,null,null,null,null,null,null,null,null,null))
                .guestName(guestName)
                .rating(rating)
                .comment(comment)
                .createdAt(createdAt)
                .user(userId)
                .build();
    }
}
