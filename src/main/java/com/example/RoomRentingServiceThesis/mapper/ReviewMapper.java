package com.example.RoomRentingServiceThesis.mapper;

import com.example.RoomRentingServiceThesis.dto.CreateReviewRequest;
import com.example.RoomRentingServiceThesis.dto.ReviewResponse;
import com.example.RoomRentingServiceThesis.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ReviewMapper {

    // Response: map fields that come from nested entities
    @Mapping(source = "room.roomId", target = "roomId")
    @Mapping(source = "renter.renterId", target = "renterId")
    @Mapping(source = "renter.fullName", target = "renterName")  // or "renter.name" if available
    // The following fields are auto‑mapped because they have the same name in Review and ReviewResponse:
    // reviewId, rating, title, comment, isVerified, helpfulCount, createdAt
    ReviewResponse toResponse(Review review);

    // Request: ignore all fields that are set later or auto‑generated
    @Mapping(target = "reviewId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "room", ignore = true)          // will be set in service
    @Mapping(target = "renter", ignore = true)        // will be set in service
    @Mapping(target = "booking", ignore = true)       // will be set in service
    @Mapping(target = "ownerResponse", ignore = true) // set by owner later
    @Mapping(target = "isVerified", ignore = true)    // default false
    @Mapping(target = "isFlagged", ignore = true)     // default false
    @Mapping(target = "helpfulCount", ignore = true)  // default 0
    Review toEntity(CreateReviewRequest dto);
}