package com.example.RoomRentingServiceThesis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "amenities")
@Getter
@Setter
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityId;

    @Column(unique = true)
    private String name;

    private String description;
    private String iconClass;
    private String category = "general";

    private Boolean isActive = true;

    @ManyToMany(mappedBy = "amenities")
    private List<Room> rooms;
}