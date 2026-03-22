package com.example.RoomRentingServiceThesis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Renter renter;

    @ManyToOne
    private Booking booking;

    private Integer rating;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String comment;

    private String ownerResponse;

    private Boolean isVerified = false;
    private Boolean isFlagged = false;

    private Integer helpfulCount = 0;
}