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
@Table(name = "owners")
@Getter
@Setter
public class Owner extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    @Column(nullable = false)
    private String passwordHash;

    private String profilePhotoUrl;

    private Boolean isVerified = false;
    private Boolean isActive = true;

    private Integer totalListings = 0;

    @Column(precision = 3, scale = 2)
    private Double averageRating = 0.0;

    @OneToMany(mappedBy = "owner")
    private List<Room> rooms;
}