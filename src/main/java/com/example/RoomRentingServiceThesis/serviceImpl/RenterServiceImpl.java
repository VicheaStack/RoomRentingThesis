package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.entity.Renter;
import com.example.RoomRentingServiceThesis.repository.RenterRepository;
import com.example.RoomRentingServiceThesis.repository.ReviewRepository;
import com.example.RoomRentingServiceThesis.service.RenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class RenterServiceImpl implements RenterService {

    private final RenterRepository renterRepository;

    public RenterServiceImpl(ReviewRepository reviewRepository,
                             RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @Override
    public Renter createRenter(String fullName, String email, String phoneNumber, String password) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name is required");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number is required");
        }

        if (renterRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists: " + email);
        }

        Renter newRenter = new Renter();
        newRenter.setFullName(fullName);
        newRenter.setEmail(email);
        newRenter.setPhoneNumber(phoneNumber);
        newRenter.setPasswordHash(password);

        return renterRepository.save(newRenter);
    }

    @Override
    public Renter getRenterById(Long renterId) {
        log.debug("Fetching renter by id: {}", renterId);

        return renterRepository.findById(renterId)
                .orElseThrow(() -> {
                    log.warn("Renter not found with id: {}", renterId);
                    return new RuntimeException("Can't find user by id");
                });
    }

    @Override
    public Renter updateRenter(Long renterId, String fullName, String email, String phoneNumber) {
        Renter existing = renterRepository.findById(renterId)
                .orElseThrow(() -> {
                    log.warn("Update failed: renter with id {} not found", renterId);
                    return new IllegalArgumentException("Renter not found with id: " + renterId);
                });

        if(fullName != null && !fullName.isBlank()){
            existing.setFullName(fullName);
            log.debug("update fullname to: {}", fullName);
       }

        if(email != null && !email.isBlank() && !email.equals(existing.getEmail())){
            if (renterRepository.existsByEmail(email)) {
                log.warn("Update failed: email {} already in use", email);
                throw new IllegalArgumentException("Email already exists: " + email);
            }
            existing.setEmail(email);
            log.debug("Updated email to: {}", email);
        }

        if(phoneNumber != null && !phoneNumber.isBlank()){
            existing.setPhoneNumber(phoneNumber);
            log.debug("update phoneNumber to: {} ", phoneNumber);
        }

        Renter updated = renterRepository.save(existing);
        log.info("Renter updated successfully: id={}, email={}", updated.getRenterId(), updated.getEmail());

        return updated;
    }

    @Override
    public void deactivateRenter(Long renterId) {
        log.debug("Attempting to deactivate renter with id: {}", renterId);

        if (!renterRepository.existsById(renterId)) {
            log.warn("Deactivation failed: renter with id {} not found", renterId);
            throw new RuntimeException("User not found");
        }

        renterRepository.deleteById(renterId);
        log.info("Renter deactivated successfully: id={}", renterId);
    }
}
