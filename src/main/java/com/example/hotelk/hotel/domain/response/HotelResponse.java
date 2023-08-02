package com.example.hotelk.hotel.domain.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.hotel.domain.entity.Promotion;
import com.example.hotelk.hotelRegion.domain.entity.HotelRegion;
import com.example.hotelk.region.domain.entity.Region;
import lombok.Getter;

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

    private List<RegionDto> regions;

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
        this.regions = hotel.getRegions().stream().map(HotelRegion::getRegion).map(RegionDto::new).toList();
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

    @Getter
    class RegionDto {
        private Long regionId;

        private String name;

        public RegionDto(Region region) {
            this.regionId = region.getRegionId();
            this.name = region.getName();
        }
    }
}
