package com.example.RoomRentingServiceThesis.service;

import com.example.RoomRentingServiceThesis.entity.Favorite;

import java.util.List;

public interface FavoriteService {

    Favorite addFavorite(Long renterId, Long roomId);

    Favorite removeFavorite(Long renterId, Long roomId);

    List<Favorite> getFavoritesByRenter(Long renterId);
}