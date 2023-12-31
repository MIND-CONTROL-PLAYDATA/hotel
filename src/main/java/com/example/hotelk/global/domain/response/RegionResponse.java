package com.example.hotelk.global.domain.response;

import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.global.domain.entity.Region;
import lombok.Getter;

@Getter
public class RegionResponse {

    private Long regionId;
    private String name;

//    private List<HotelDto> hotels;

    public RegionResponse(Region region) {
        this.regionId = region.getRegionId();
        this.name = region.getName();
//        this.hotels = region.getHotels().stream().map(HotelRegion::getHotel).map(HotelDto::new).toList();
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
}
