package com.example.RoomRentingServiceThesis.service;

import java.util.List;

public interface FavoriteService {

    void addFavorite(Long renterId, Long roomId);

    void removeFavorite(Long renterId, Long roomId);

    List<Object> getFavoritesByRenter(Long renterId);
}