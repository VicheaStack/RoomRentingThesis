package com.example.RoomRentingServiceThesis.dto;

public record CreatePaymentRequest(
    Long bookingId,
    Double amount,
    String paymentMethod
) {}