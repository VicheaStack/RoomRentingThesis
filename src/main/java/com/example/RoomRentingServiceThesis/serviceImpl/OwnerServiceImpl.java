package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.entity.Owner;
import com.example.RoomRentingServiceThesis.repository.OwnerRepository;
import com.example.RoomRentingServiceThesis.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner createOwner(String fullName, String email, String phoneNumber, String passwordHash) {
        if(fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name is required");
        }

        if(email == null || email.isBlank()) {
            throw new IllegalArgumentException("email is required");
        }

        if(phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("phoneNumber is required");
        }

        if(passwordHash == null || passwordHash.isBlank()) {
            throw new IllegalArgumentException("password is required");
        }

        if(ownerRepository.existsByEmail(email)){
            throw new IllegalArgumentException("email is already exist " + email);
        }

        Owner owner = new Owner();
        owner.setFullName(fullName);
        owner.setEmail(email);
        owner.setPhoneNumber(phoneNumber);
        owner.setPasswordHash(passwordHash);

        Owner save = ownerRepository.save(owner);
        return save;
    }

    @Override
    public Owner getOwnerById(Long ownerId) {
        log.debug("Fetching owner with id: {} ", ownerId);

        return ownerRepository.findById(ownerId).orElseThrow(() -> {
            log.warn("Owner not found with id: {} ", ownerId);
            return new RuntimeException("Owner not exist ");
        });
    }

    @Override
    public void deactivateOwner(Long ownerId) {
        log.debug("Attempting to deactivate owner with id: {}", ownerId);

        if(!ownerRepository.existsById(ownerId)) {
            log.warn("Deactivation failed: owner with id {} not found", ownerId);
            throw new RuntimeException("Owner not found");
        }

        ownerRepository.deleteById(ownerId);
        log.info("Owner deactivated successfully: id={}", ownerId);
    }
}
