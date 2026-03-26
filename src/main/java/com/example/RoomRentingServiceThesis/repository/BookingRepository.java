package com.example.RoomRentingServiceThesis.repository;


import com.example.RoomRentingServiceThesis.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRenter_RenterId(Long renterId);

    List<Booking> findByRoom_RoomId(Long roomId);

    List<Booking> findByStatus(String status);

    @Query("SELECT b FROM Booking b WHERE b.room.roomId = :roomId " +
            "AND b.startDate < :endDate AND b.endDate > :startDate")
    List<Booking> findOverlappingBookings(@Param("roomId") Long roomId,
                                          @Param("startDate") LocalDate startDate,
                                          @Param("endDate") LocalDate endDate);

}