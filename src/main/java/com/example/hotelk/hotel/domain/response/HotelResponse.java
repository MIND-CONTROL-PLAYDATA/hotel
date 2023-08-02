package com.example.hotelk.hotel.domain.response;

import com.example.hotelk.amenities.domain.entity.Amenities;
import com.example.hotelk.amenities.domain.response.AmenitiesResponse;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.hotel.domain.entity.Promotion;
import com.example.hotelk.hotelFacility.domain.entity.HotelFacility;
import com.example.hotelk.hotelFacilityUsage.domain.entity.HotelFacilityUsage;
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
    private List<AmenitiesDto> amenities;
    private List<HotelFacilityDto> hotelFacilities;

    private List<HotelFacilityUsageDto> hotelFacilityUsages;

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

        this.amenities = hotel.getAmenities().stream().map(AmenitiesDto::new).toList();
        this.hotelFacilities = hotel.getHotelFacilities().stream().map(HotelFacilityDto::new).toList();

        this.hotelFacilityUsages = hotel.getHotelFacilityUsages().stream().map(HotelFacilityUsageDto::new).toList();
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


    @Getter
    class AmenitiesDto {
        private Long amenityId;
        private String name;
        private String description;

        public AmenitiesDto(Amenities amenities) {
            this.amenityId = amenities.getAmenityId();
            this.name = amenities.getName();
            this.description = amenities.getDescription();
        }
    }

    @Getter
    class HotelFacilityDto {
        private Long facilityId;

        private Hotel hotel;

        private String name;
        private String description;


        public HotelFacilityDto(HotelFacility hotelFacility) {
            this.facilityId = hotelFacility.getFacilityId();
            this.hotel = hotelFacility.getHotel();
            this.name = hotel.getName();
            this.description = hotel.getDescription();
        }
    }

    @Getter
    class HotelFacilityUsageDto {
        private Long usageId;

        private String guestName;

        private Timestamp usageDate;
        private Timestamp usageTime;

        public HotelFacilityUsageDto(HotelFacilityUsage hotelFacilityUsage) {
            this.usageId = hotelFacilityUsage.getUsageId();
            this.guestName = hotelFacilityUsage.getGuestName();
            this.usageDate = hotelFacilityUsage.getUsageDate();
            this.usageTime = hotelFacilityUsage.getUsageTime();
        }
    }
}