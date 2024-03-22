package com.msvc.ratings.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.ratings.entities.Rating;
import com.msvc.ratings.repository.RatingsRepository;
import com.msvc.ratings.services.RatingService;

import java.util.List;

@Service
public class CalificacionServiceImpl implements RatingService {

    @Autowired
    private RatingsRepository ratingsRepository;

    @Override
    @SuppressWarnings("null")
    public Rating putRating(Rating rating) {
        return ratingsRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingsRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingsRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingsRepository.findByHotelId(hotelId);
    }
}
