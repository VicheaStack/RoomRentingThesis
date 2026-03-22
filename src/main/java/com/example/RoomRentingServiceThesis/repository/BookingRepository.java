package com.example.RoomRentingServiceThesis.repository;

import com.example.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRenter_RenterId(Long renterId);

    List<Booking> findByRoom_RoomId(Long roomId);

    List<Booking> findByStatus(String status);

}