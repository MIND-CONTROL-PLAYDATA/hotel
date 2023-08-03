package com.example.hotelk.user.domain.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.user.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewResponse {
    private Hotel hotelName;
    private String guestName;
    private Double rating;
    private String comment;
    private LocalDateTime createdAt;

    public ReviewResponse(Review review) {
        this.hotelName = review.getHotel();
        this.guestName = review.getGuestName();
        this.rating = review.getRating();
        this.comment = review.getComment();
        this.createdAt = review.getCreatedAt();
    }
}
