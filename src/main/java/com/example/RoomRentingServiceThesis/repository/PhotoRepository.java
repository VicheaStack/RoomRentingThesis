package com.example.RoomRentingServiceThesis.repository;


import com.example.RoomRentingServiceThesis.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findByRoom_RoomId(Long roomId);

    List<Photo> findByRoom_RoomIdOrderByDisplayOrderAsc(Long roomId);

}