package com.example.RoomRentingServiceThesis.dto;

import java.time.LocalDateTime;

public record PaymentResponse(
    Long paymentId,
    Long bookingId,
    Double amount,
    String currency,
    String paymentMethod,
    String status,
    String transactionId,
    LocalDateTime paidAt
) {}