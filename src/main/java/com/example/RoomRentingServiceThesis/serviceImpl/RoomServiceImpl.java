package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.entity.Owner;
import com.example.RoomRentingServiceThesis.entity.Room;
import com.example.RoomRentingServiceThesis.repository.OwnerRepository;
import com.example.RoomRentingServiceThesis.repository.RoomRepository;
import com.example.RoomRentingServiceThesis.service.RoomService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final OwnerRepository ownerRepository;

    public RoomServiceImpl(RoomRepository roomRepository, OwnerRepository ownerRepository) {
        this.roomRepository = roomRepository;
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    @Override
    public Long createRoom(Long ownerId, String title, String description, double price, String location) {

        if(ownerId == null) throw new IllegalArgumentException("Owner can't be null: ");

        if(title == null) throw new IllegalArgumentException("title can't empty ");

        if(description == null) throw new IllegalArgumentException("description can't be empty ");

        if(price == 0) throw new IllegalArgumentException("price can't be empty ");

        if(location == null) throw new IllegalArgumentException("location can't be empty ");

        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found with id: {} " + ownerId));

        Room room = new Room();
        room.setOwner(owner);
        room.setTitle(title);
        room.setDescription(description);
        room.setLocation(location);
        room.setPricePerMonth(price);

        Room save = roomRepository.save(room);

        return save.getRoomId();
    }

    @Override
    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("can't be found with id"));
    }

    @Override
    public List<Room> searchRooms(String location, Double minPrice, Double maxPrice, String roomType, Boolean verified) {

        Specification<Room> roomSpecification = Specification
                .where(RoomSpecification.locationContain(location))
                .and(RoomSpecification.priceBetween(minPrice, maxPrice))
                .and(RoomSpecification.roomTypeEquals(roomType))
                .and(RoomSpecification.verifiedEquals(verified));

        return roomRepository.findAll();
    }

    @Override
    public void deleteRoom(Long roomId) {
        if(roomRepository.findById(roomId).isEmpty())
            throw new RuntimeException("Room not found by id");
        roomRepository.deleteById(roomId);
    }
}
