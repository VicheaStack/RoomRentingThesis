package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.repository.OwnerRepository;
import com.example.RoomRentingServiceThesis.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void createOwner(String fullName, String email, String phone, String password) {

    }

    @Override
    public Object getOwnerById(Long ownerId) {
        return null;
    }

    @Override
    public void deactivateOwner(Long ownerId) {

    }
}
