package com.example.RoomRentingServiceThesis.repository;

import com.example.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByBooking_BookingId(Long bookingId);

    Optional<Payment> findByTransactionId(String transactionId);

}