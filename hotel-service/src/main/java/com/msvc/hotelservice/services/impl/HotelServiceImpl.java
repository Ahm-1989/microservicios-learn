package com.msvc.hotelservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.hotelservice.entity.Hotel;
import com.msvc.hotelservice.exceptions.ResourceNotFountException;
import com.msvc.hotelservice.repository.HotelRepository;
import com.msvc.hotelservice.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

  @Autowired
  private HotelRepository hotelRepository;

  @Override
  public Hotel create(Hotel hotel) {
    String hotelId = UUID.randomUUID().toString();
    hotel.setHotelId(hotelId);
    return hotelRepository.save(hotel);
  }

  @Override
  public List<Hotel> getAll() {
    return hotelRepository.findAll();
  }

  @Override
  @SuppressWarnings("null")
  public Hotel getOne(String hotelId) {
    return hotelRepository.findById(hotelId)
      .orElseThrow(
        () -> new ResourceNotFountException(
          "Hotel its not posible found in this collection, try again with other hotelId: " + hotelId));
  }
}
