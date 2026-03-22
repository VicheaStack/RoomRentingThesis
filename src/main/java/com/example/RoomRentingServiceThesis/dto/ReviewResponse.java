package com.example.RoomRentingServiceThesis.dto;

import java.time.LocalDateTime;

public record ReviewResponse(
    Long reviewId,
    Long roomId,
    Long renterId,
    String renterName,
    Integer rating,
    String title,
    String comment,
    Boolean isVerified,
    Integer helpfulCount,
    LocalDateTime createdAt
) {}