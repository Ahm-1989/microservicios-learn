package com.msvc.ratingservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.msvc.ratingservice.entity.Rating;

public interface RatingRepository extends MongoRepository<Rating,Long> {
    List<Rating> findAllUserById(String userId);
    List<Rating> findAllHotelById(String hotelId);
}
