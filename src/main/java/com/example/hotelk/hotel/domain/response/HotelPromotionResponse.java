package com.example.hotelk.hotel.domain.response;

import com.example.hotelk.global.domain.entity.Promotion;
import com.example.hotelk.global.domain.entity.Region;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
public class HotelPromotionResponse {
    List<HotelDto> hotels;

    List<PromotionDto> promotionDtos;

    public HotelPromotionResponse(HotelPromotion hotelPromotion) {
        this.hotels = hotelPromotion.getPromotion().getHotels().stream().map(HotelPromotion::getHotel).map(HotelPromotionResponse.HotelDto::new).toList();
        this.promotionDtos = hotelPromotion.getHotel().getPromotions().stream().map(HotelPromotion::getPromotion).map(HotelPromotionResponse.PromotionDto::new).toList();
    }

    @Getter
    class HotelDto {
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
