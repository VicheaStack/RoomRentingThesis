package com.example.RoomRentingServiceThesis.serviceImpl;

import com.example.RoomRentingServiceThesis.entity.Room;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;      // ✅ fixed import
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class RoomSpecification {

    public static Specification<Room> locationContain(String location){
        return (root, query, criteriaBuilder) -> {
            if(location == null || location.isBlank()) return criteriaBuilder.conjunction();
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("location")), "%" + location.toLowerCase() + "%");
        };
    }

    public static Specification<Room> priceBetween(Double minPrice, Double maxPrice){
        return (root, query, criteriaBuilder) -> {

            if (minPrice == null && maxPrice == null) return criteriaBuilder.conjunction();

            Path<Double> pricePath = root.get("price");     // ✅ fixed field name (was "Price")
            List<Predicate> predicate = new ArrayList<>();

            if(minPrice != null) predicate.add(criteriaBuilder.ge(pricePath, minPrice));

            if(maxPrice != null) predicate.add(criteriaBuilder.le(pricePath, maxPrice));

            return criteriaBuilder.and(predicate.toArray(new Predicate[0]));
        };
    }

    public static Specification<Room> roomTypeEquals(String roomType) {
        return (root, query, criteriaBuilder) -> {

            if (roomType == null || roomType.isBlank()) return criteriaBuilder.conjunction();

            return criteriaBuilder.equal(root.get("roomType"), roomType);
        };
    }

    public static Specification<Room> verifiedEquals(Boolean verified) {
        return (root, query, cb) -> {
            if (verified == null) {
                return cb.conjunction();
            }
            return cb.equal(root.get("verified"), verified);
        };
    }
}