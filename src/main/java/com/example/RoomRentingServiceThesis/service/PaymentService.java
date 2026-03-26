package com.example.RoomRentingServiceThesis.service;

public interface PaymentService {

    Long createPayment(Long bookingId, double amount, String currency, String method);

    Object getPaymentByBookingId(Long bookingId);

    void refundPayment(Long paymentId);
}