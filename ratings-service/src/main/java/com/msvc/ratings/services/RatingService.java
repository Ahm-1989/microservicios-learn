package com.msvc.ratings.services;

import java.util.List;

import com.msvc.ratings.entities.Rating;

public interface RatingService {

    Rating putRating(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingsByUserId(String userId);

    List<Rating> getRatingsByHotelId(String hotelId);

}
