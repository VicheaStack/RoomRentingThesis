package com.example.RoomRentingServiceThesis.mapper;

import com.example.RoomRentingServiceThesis.dto.CreateRenterRequest;
import com.example.RoomRentingServiceThesis.dto.RenterResponse;
import com.example.RoomRentingServiceThesis.entity.Renter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RenterMapper {

    RenterResponse toResponse(Renter renter);

    @Mapping(target = "renterId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)   // set in service after hashing
    @Mapping(target = "profilePhotoUrl", ignore = true) // optional, set later
    @Mapping(target = "isVerified", ignore = true)     // default false
    @Mapping(target = "isActive", ignore = true)       // default true
    @Mapping(target = "bookings", ignore = true)       // empty list
    @Mapping(target = "reviews", ignore = true)        // empty list
    Renter toEntity(CreateRenterRequest dto);

}