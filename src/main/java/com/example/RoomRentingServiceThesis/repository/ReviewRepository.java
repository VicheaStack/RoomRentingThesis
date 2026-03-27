package com.example.RoomRentingServiceThesis.repository;


import com.example.RoomRentingServiceThesis.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByRoom_RoomId(Long roomId);
    List<Review> findByRoomId(Long roomId);

    List<Review> findByRenter_RenterId(Long renterId);

}