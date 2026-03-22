package com.example.RoomRentingServiceThesis.dto;

import java.time.LocalDateTime;

public record RenterResponse(
    Long renterId,
    String fullName,
    String email,
    String phoneNumber,
    String profilePhotoUrl,
    Boolean isVerified,
    Boolean isActive,
    LocalDateTime createdAt
) {}