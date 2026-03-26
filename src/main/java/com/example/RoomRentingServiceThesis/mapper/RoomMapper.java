package com.example.RoomRentingServiceThesis.mapper;

import com.example.RoomRentingServiceThesis.dto.CreateRoomRequest;
import com.example.RoomRentingServiceThesis.dto.RoomResponse;
import com.example.RoomRentingServiceThesis.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AmenityMapper.class, PhotoMapper.class})
public interface RoomMapper {

    RoomResponse toResponse(Room room);

    @Mapping(target = "roomId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "owner", ignore = true)          // set later by ID
    @Mapping(target = "status", ignore = true)         // default "available"
    @Mapping(target = "sizeSqft", ignore = true)       // if not in request
    @Mapping(target = "isVerified", ignore = true)     // default false
    @Mapping(target = "totalViews", ignore = true)     // default 0
    @Mapping(target = "totalBookings", ignore = true)  // default 0
    @Mapping(target = "averageRating", ignore = true)  // default 0.0
    @Mapping(target = "photos", ignore = true)         // set later
    @Mapping(target = "bookings", ignore = true)       // empty list
    @Mapping(target = "amenities", ignore = true)      // set later via IDs
    Room toEntity(CreateRoomRequest dto);
}