package com.example.hotelk.hotel.domain.response;

import com.example.hotelk.global.domain.entity.Region;
import com.example.hotelk.hotel.domain.entity.Hotel;
import com.example.hotelk.hotel.domain.entity.HotelRegion;
import com.example.hotelk.hotel.domain.entity.HotelRoom;
import com.example.hotelk.room.domain.entity.Room;
import lombok.Getter;

import java.util.List;

@Getter
public class HotelRoomResponse {
    List<HotelDto> hotels;

    List<RoomDto> rooms;

    public HotelRoomResponse(HotelRoom hotelRoom) {
        this.hotels = hotelRoom.getRoom().getHotels().stream().map(HotelRoom::getHotel).map(HotelRoomResponse.HotelDto::new).toList();
        this.rooms = hotelRoom.getHotel().getRooms().stream().map(HotelRoom::getRoom).map(HotelRoomResponse.RoomDto::new).toList();
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
}
