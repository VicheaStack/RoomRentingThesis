package com.example.RoomRentingServiceThesis.mapper;

import com.example.RoomRentingServiceThesis.dto.CreateOwnerRequest;
import com.example.RoomRentingServiceThesis.dto.OwnerResponse;
import com.example.RoomRentingServiceThesis.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerResponse toResponse(Owner owner);

    @Mapping(target = "ownerId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "profilePhotoUrl", ignore = true)
    @Mapping(target = "isVerified", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "totalListings", ignore = true)
    @Mapping(target = "averageRating", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    Owner toEntity(CreateOwnerRequest dto);
}