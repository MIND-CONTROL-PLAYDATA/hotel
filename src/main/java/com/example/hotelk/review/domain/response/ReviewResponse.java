package com.example.hotelk.review.domain.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.review.domain.entity.Review;
import com.example.hotelk.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewResponse {
    private Hotel hotelName;
    private String guestName;
    private Double rating;
    private String comment;

    public ReviewResponse(Review review) {
        this.hotelName = review.getHotel();
        this.guestName = review.getGuestName();
        this.rating = review.getRating();
        this.comment = review.getComment();
    }
}
