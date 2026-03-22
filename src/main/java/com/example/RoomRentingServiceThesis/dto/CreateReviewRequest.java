package com.example.RoomRentingServiceThesis.dto;

public record CreateReviewRequest(
    Long bookingId,
    Integer rating,
    String title,
    String comment
) {}