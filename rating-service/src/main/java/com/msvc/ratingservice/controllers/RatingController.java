package com.msvc.ratingservice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.msvc.ratingservice.entity.Rating;
import com.msvc.ratingservice.services.RatingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/ratings")
public class RatingController {

  @Autowired
  private RatingService ratingService;

  @PostMapping
  public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(ratingService.createRating(rating));
  }

  @GetMapping
  public ResponseEntity<List<Rating>> getAllRatings() {
    return ResponseEntity
      .ok(ratingService.geRatings());
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Rating>> getAllRatingByUser(@PathVariable String userId) {
    return ResponseEntity.ok(ratingService.geRatingsByUserId(userId));
  }

  @GetMapping("/hotel/{hotelId}")
  public ResponseEntity<List<Rating>> getAllRatingsByHotel(@PathVariable String hotelId) {
    return ResponseEntity.ok(ratingService.geRatingsByHotelId(hotelId));
  }
}
