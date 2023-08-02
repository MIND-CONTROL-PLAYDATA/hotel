package com.example.hotelk.hotel.domain.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.hotel.domain.entity.Promotion;
import com.example.hotelk.hotel.domain.request.HotelRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
public class HotelResponse {

    private Long hotelId;

    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private String email;
    private String url;
    private List<PromotionDto> promotions;

    public HotelResponse(Hotel hotel) {
        this.hotelId = hotel.getHotelId();
        this.name = hotel.getName();
        this.description = hotel.getDescription();
        this.address = hotel.getAddress();
        this.phoneNumber = hotel.getPhoneNumber();
        this.email = hotel.getEmail();
        this.url = hotel.getUrl();
        this.promotions = hotel.getPromotions() != null ?

                hotel.getPromotions()
                        .stream()
                        .map(HotelPromotion::getPromotion)
                        .map(PromotionDto::new)
                        .toList()
                : new ArrayList<>();
    }
    @Getter
    class PromotionDto {
        private Long promotionId;

        private String title;
        private String description;
        private Timestamp startDate;
        private Timestamp endDate;


        public PromotionDto(Promotion promotion) {
            this.promotionId = promotion.getPromotionId();
            this.title = promotion.getTitle();
            this.description = promotion.getDescription();
            this.startDate = promotion.getStartDate();
            this.endDate = promotion.getEndDate();
        }
    }
}
