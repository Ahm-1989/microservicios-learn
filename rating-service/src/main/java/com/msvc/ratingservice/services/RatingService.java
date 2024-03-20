package com.msvc.ratingservice.services;

import java.util.List;

import com.msvc.ratingservice.entity.Rating;

public interface RatingService {

  Rating createRating(Rating rating);

  List<Rating> geRatings();

  List<Rating> geRatingsByUserId(String userId);

  List<Rating> geRatingsByHotelId(String hotelId);
}
