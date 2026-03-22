package com.example.RoomRentingServiceThesis.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BookingResponse(
    Long bookingId,
    Long roomId,
    String roomTitle,
    Long renterId,
    String renterName,
    LocalDate startDate,
    LocalDate endDate,
    Integer totalNights,
    Double totalAmount,
    String status,
    LocalDateTime createdAt
) {}