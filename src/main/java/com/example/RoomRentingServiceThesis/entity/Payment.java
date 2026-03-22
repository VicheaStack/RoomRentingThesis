package com.example.RoomRentingServiceThesis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private Double amount;

    private String currency = "USD";
    private String paymentMethod;
    private String status = "pending";

    @Column(unique = true)
    private String transactionId;

    @Column(columnDefinition = "TEXT")
    private String gatewayResponse;

    private String receiptUrl;

    private LocalDateTime paidAt;
    private LocalDateTime refundedAt;
}