package com.example.RoomRentingServiceThesis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class Room extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double pricePerMonth;

    private String location;

    private Double latitude;
    private Double longitude;

    private String roomType = "single";
    private String status = "available";

    private Integer sizeSqft;
    private Integer maxOccupancy = 1;

    private Boolean hasPrivateBathroom = false;
    private Boolean isFurnished = false;
    private Boolean isVerified = false;

    private Integer totalViews = 0;
    private Integer totalBookings = 0;

    @Column(precision = 3, scale = 2)
    private Double averageRating = 0.0;

    @OneToMany(mappedBy = "room")
    private List<Photo> photos;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    @ManyToMany
    @JoinTable(
        name = "room_amenities",
        joinColumns = @JoinColumn(name = "room_id"),
        inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private List<Amenity> amenities;
}