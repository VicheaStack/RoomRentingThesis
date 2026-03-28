package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.entity.Favorite;
import com.example.RoomRentingServiceThesis.entity.Renter;
import com.example.RoomRentingServiceThesis.entity.Room;
import com.example.RoomRentingServiceThesis.repository.FavoriteRepository;
import com.example.RoomRentingServiceThesis.repository.RenterRepository;
import com.example.RoomRentingServiceThesis.repository.RoomRepository;
import com.example.RoomRentingServiceThesis.service.FavoriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {

    private static final Logger log = LoggerFactory.getLogger(FavoriteServiceImpl.class);

    private final FavoriteRepository favoriteRepository;
    private final RenterRepository renterRepository;
    private final RoomRepository roomRepository;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository,
                               RenterRepository renterRepository,
                               RoomRepository roomRepository) {
        this.favoriteRepository = favoriteRepository;
        this.renterRepository = renterRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Favorite addFavorite(Long renterId, Long roomId) {
        log.debug("Adding favorite: renterId={}, roomId={}", renterId, roomId);

        Renter renter = renterRepository.findById(renterId)
                .orElseThrow(() -> {
                    log.warn("Renter not found with id: {}", renterId);
                    return new RuntimeException("Renter not found with id: " + renterId);
                });

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> {
                    log.warn("Room not found with id: {}", roomId);
                    return new RuntimeException("Room not found with id: " + roomId);
                });

        if (favoriteRepository.existsByRenter_RenterIdAndRoom_RoomId(renterId, roomId)) {
            log.warn("Favorite already exists for renterId={}, roomId={}", renterId, roomId);
            throw new RuntimeException("Favorite already exists for this renter and room");
        }

        Favorite favorite = new Favorite();
        favorite.setRenter(renter);
        favorite.setRoom(room);

        Favorite saved = favoriteRepository.save(favorite);
        log.info("Favorite added successfully: id={}, renterId={}, roomId={}",
                saved.getFavoriteId(), renterId, roomId);

        return saved;
    }

    @Override
    public Favorite removeFavorite(Long renterId, Long roomId) {
        log.debug("Removing favorite: renterId={}, roomId={}", renterId, roomId);

        Favorite favorite = favoriteRepository.findByRenter_RenterIdAndRoom_RoomId(renterId, roomId)
                .orElseThrow(() -> {
                    log.warn("Favorite not found for renterId={}, roomId={}", renterId, roomId);
                    return new RuntimeException("Favorite not found for this renter and room");
                });

        favoriteRepository.delete(favorite);
        log.info("Favorite removed successfully: id={}, renterId={}, roomId={}",
                favorite.getFavoriteId(), renterId, roomId);

        return favorite;
    }

    @Override
    public List<Favorite> getFavoritesByRenter(Long renterId) {
        log.debug("Fetching favorites for renterId: {}", renterId);

        if (!renterRepository.existsById(renterId)) {
            log.warn("Renter not found with id: {}", renterId);
            throw new RuntimeException("Renter not found with id: " + renterId);
        }

        List<Favorite> favorites = favoriteRepository.findByRenter_RenterId(renterId);
        log.debug("Found {} favorites for renterId={}", favorites.size(), renterId);
        return favorites;
    }
}