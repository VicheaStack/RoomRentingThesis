package com.example.RoomRentingServiceThesis.repository;


import com.example.RoomRentingServiceThesis.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByRenter_RenterId(Long renterId);

    Optional<Favorite> findByRenter_RenterIdAndRoom_RoomId(Long renterId, Long roomId);

    boolean existsByRenter_RenterIdAndRoom_RoomId(Long renterId, Long roomId);

}