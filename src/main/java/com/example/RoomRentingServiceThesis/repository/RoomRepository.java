package com.example.RoomRentingServiceThesis.repository;


import com.example.RoomRentingServiceThesis.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Page<Room> findByLocationContainingIgnoreCase(String location, Pageable pageable);

    Page<Room> findByPricePerMonthBetween(Double min, Double max, Pageable pageable);

    Page<Room> findByRoomType(String roomType, Pageable pageable);

    Page<Room> findByStatus(String status, Pageable pageable);

    Page<Room> findByIsVerifiedTrue(Pageable pageable);

}