package com.example.hotelk.user.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class ReviewRequest {
    private Long hotelId;
    private String guestName;
    private Double rating;
    private String comment;
    private LocalDateTime createdAt;
    private Long userId;

   /* public Review toEntity() {
        createdAt = LocalDateTime.now();
        return Review.builder()
                .hotel(new Hotel(hotelId,null,null,null,null,null,null,null,null,null,null,null,null,null,null))
                .guestName(guestName)
                .rating(rating)
                .comment(comment)
                .createdAt(createdAt)
                .user(userId)
                .build();
    }*/
}
