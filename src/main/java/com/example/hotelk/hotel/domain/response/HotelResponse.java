package com.example.hotelk.hotel.domain.response;

import com.example.hotelk.amenities.domain.entity.Amenities;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelPromotion;
import com.example.hotelk.global.domain.entity.Promotion;
import com.example.hotelk.global.domain.entity.Facility;
import com.example.hotelk.global.domain.entity.FacilityUsage;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import com.example.hotelk.global.domain.entity.Region;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import com.example.hotelk.hotel.domain.entity.HotelRoom;
import com.example.hotelk.room.domain.entity.Room;

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
    private Double totalRate;
    private Double numCommentPeople;
    private Double avgRate;
    private List<PromotionDto> promotions;
    private List<RoomDto> rooms;

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
        this.totalRate = hotel.getTotalRate();
        this.numCommentPeople = hotel.getNumCommentPeople();
        this.avgRate = hotel.getTotalRate()/hotel.getNumCommentPeople();
        this.promotions = hotel.getPromotions() != null ?

                hotel.getPromotions()
                        .stream()
                        .map(HotelPromotion::getPromotion)
                        .map(PromotionDto::new)
                        .toList()
                : new ArrayList<>();
        this.rooms = hotel.getRooms() != null ?

                hotel.getRooms()
                        .stream()
                        .map(HotelRoom::getRoom)
                        .map(RoomDto::new)
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
    class RoomDto {
        private Long roomId;

        private String name;
        private String type;
        private Double price;
        private Integer capacity;
        private String description;


        public RoomDto(Room room) {
            this.roomId = room.getRoomId();
            this.name = room.getName();
            this.type = room.getType();
            this.price = room.getPrice();
            this.capacity = room.getCapacity();
            this.description = room.getDescription();
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


        private String name;
        private String description;


        public HotelFacilityDto(Facility hotelFacility) {
            this.facilityId = hotelFacility.getFacilityId();
            this.name = hotelFacility.getName();
            this.description = hotelFacility.getDescription();
        }
    }

    @Getter
    class HotelFacilityUsageDto {
        private Long usageId;

        private String guestName;

        private LocalDate usageDate;
        private LocalTime usageTime;

        public HotelFacilityUsageDto(FacilityUsage hotelFacilityUsage) {
            this.usageId = hotelFacilityUsage.getUsageId();
            this.guestName = hotelFacilityUsage.getGuestName();
            this.usageDate = hotelFacilityUsage.getUsageDate();
            this.usageTime = hotelFacilityUsage.getUsageTime();
        }
    }
}
