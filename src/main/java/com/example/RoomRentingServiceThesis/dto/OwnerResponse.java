package com.example.RoomRentingServiceThesis.dto;

import java.time.LocalDateTime;

public record OwnerResponse(
    Long ownerId,
    String fullName,
    String email,
    String phoneNumber,
    String profilePhotoUrl,
    Boolean isVerified,
    Boolean isActive,
    Integer totalListings,
    Double averageRating,
    LocalDateTime createdAt
) {}