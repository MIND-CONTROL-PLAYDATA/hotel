package com.example.hotelk.hotel.domain.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.Promotion;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PromotionResponse {
    private Long promotionId;
    private String title;
    private String description;
    private Timestamp startDate;
    private Timestamp endDate;
    private List<HotelDto> hotels;

    public PromotionResponse(Promotion promotion) {
        this.promotionId = promotion.getPromotionId();
        this.title = promotion.getTitle();
        this.description = promotion.getDescription();
        this.startDate = promotion.getStartDate();
        this.endDate = promotion.getEndDate();
        this.hotels = promotion.getHotels() != null ?
                promotion.getHotels()
                        .stream()
                        .map(h -> new HotelDto(h.getHotel()))
                        .toList()
                : new ArrayList<>();
    }

    @Getter
    class HotelDto{
        private Long hotelId;
        private String name;
        private String description;
        private String address;
        private String phoneNumber;
        private String email;
        private String url;

        public HotelDto(Hotel hotel) {
            this.hotelId = hotel.getHotelId();
            this.name = hotel.getName();
            this.description = hotel.getDescription();
            this.address = hotel.getAddress();
            this.phoneNumber = hotel.getPhoneNumber();
            this.email = hotel.getEmail();
            this.url = hotel.getUrl();
        }
    }
}
