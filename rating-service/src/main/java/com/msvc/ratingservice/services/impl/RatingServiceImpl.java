package com.msvc.ratingservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.msvc.ratingservice.entity.Rating;
import com.msvc.ratingservice.repository.RatingRepository;
import com.msvc.ratingservice.services.RatingService;

public class RatingServiceImpl implements RatingService {

  @Autowired
  private RatingRepository ratingRepository;

  @Override
  public Rating createRating(Rating rating) {
    return ratingRepository.save(rating);
  }

  @Override
  public List<Rating> geRatings() {
    return ratingRepository.findAll();
  }

  @Override
  public List<Rating> geRatingsByUserId(String userId) {
    return ratingRepository.findAllUserById(userId);
  }

  @Override
  public List<Rating> geRatingsByHotelId(String hotelId) {
    return ratingRepository.findAllHotelById(hotelId);
  }
}
