package com.example.RoomRentingServiceThesis.mapper;

import com.example.RoomRentingServiceThesis.dto.FavoriteResponse;
import com.example.RoomRentingServiceThesis.entity.Favorite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {

    @Mapping(target = "renterId", source = "renter.renterId")
    @Mapping(target = "roomId", source = "room.roomId")
    FavoriteResponse toResponse(Favorite favorite);
}