package com.msvc.hotelservice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.msvc.hotelservice.entity.Hotel;
import com.msvc.hotelservice.services.HotelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  @Autowired
  private HotelService hotelService;

  @PostMapping
  public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(hotelService.create(hotel));
  }

  @GetMapping  
  public ResponseEntity<List<Hotel>> listHotels() {
    return ResponseEntity
      .status(HttpStatus.FOUND)
      .body(hotelService.getAll());
  }

  @GetMapping("/{hotelId}")
  public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
    return ResponseEntity
      .status(HttpStatus.FOUND)
      .body(hotelService.getOne(hotelId));
  }
}
