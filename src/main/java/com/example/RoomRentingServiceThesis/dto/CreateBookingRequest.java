package com.example.RoomRentingServiceThesis.dto;

import java.time.LocalDate;

public record CreateBookingRequest(
    Long roomId,
    Long renterId,
    LocalDate startDate,
    LocalDate endDate
) {}