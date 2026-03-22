package com.example.RoomRentingServiceThesis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "renters")
@Getter
@Setter
public class Renter extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long renterId;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String phoneNumber;

    @Column(nullable = false)
    private String passwordHash;

    private String profilePhotoUrl;

    private Boolean isVerified = false;
    private Boolean isActive = true;

    @OneToMany(mappedBy = "renter")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "renter")
    private List<Review> reviews;
}