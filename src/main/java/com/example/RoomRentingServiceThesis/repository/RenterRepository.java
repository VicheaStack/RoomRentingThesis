package com.example.RoomRentingServiceThesis.repository;


import com.example.RoomRentingServiceThesis.entity.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RenterRepository extends JpaRepository<Renter, Long> {

    Optional<Renter> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Renter> findRentersByRenterId(Long renterId);
}